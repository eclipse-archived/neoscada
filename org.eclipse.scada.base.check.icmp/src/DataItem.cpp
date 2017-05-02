/*******************************************************************************
 * Copyright (c) 2008, 2013 TH4 SYSTEMS GmbH and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     TH4 SYSTEMS GmbH - initial API and implementation
 *     IBH SYSTEMS GmbH - prepare for Eclipse SCADA contribution
 *******************************************************************************/
#include "DataItem.h"

DataItem::DataItem ( const std::string & id, int ioDirections ) :
  _id ( id ),
  _ioDirections ( ioDirections ),
  _registeredHive ( NULL ),
  _lastValue ( NULL )
{
}

DataItem::~DataItem ()
{
  if ( _registeredHive != NULL )
  {
    _registeredHive->unregisterItem ( this );
  }
  if ( _lastValue != NULL )
  {
    delete _lastValue;
  }
}

std::string DataItem::id () const
{
  return _id;
}

int DataItem::ioDirections () const
{
  return _ioDirections;
}

void DataItem::setHive ( Hive * hive )
{
  _registeredHive = hive;
}

void DataItem::updateValue ( const std::string & value )
{
    updateValue ( std::auto_ptr<std::string> ( new std::string ( value ) ), std::map<std::string, std::string> () );
}

void DataItem::updateValue ( std::auto_ptr<std::string> value, std::map<std::string, std::string> attributes )
{
  if ( _registeredHive == NULL )
  {
    return;
  }

  bool doUpdate = false;

  if ( value.get () != NULL )
  {
    if ( _lastValue == NULL || *_lastValue != *value )
    {
      if ( _lastValue != NULL )
      {
        delete _lastValue;
      }
      _lastValue = new std::string ( *value );
      doUpdate = true;
    }
  }

  // perform change detection in mode "SET"
  std::map<std::string,std::string> newLastAttributes;
  std::map<std::string,std::string> changedAttributes;
  for ( std::map<std::string, std::string>::iterator i = attributes.begin (); i != attributes.end (); i++ )
  {
    std::map<std::string, std::string>::iterator i2 = _lastAttributes.find ( i->first );
    if ( i2 != _lastAttributes.end () )
    {
      newLastAttributes[i->first] = i->second;
      if ( i2->second != i->second )
      {
        changedAttributes[i->first] = i->second;
      }
      _lastAttributes.erase ( i->first );
    }
    else
    {
      newLastAttributes[i->first] = i->second;
      changedAttributes[i->first] = i->second;
    }
  }
  for ( std::map<std::string, std::string>::iterator i = _lastAttributes.begin (); i != _lastAttributes.end (); i++ )
  {
    changedAttributes[i->first] = "NULL#";
  }
  _lastAttributes = newLastAttributes;

  if ( changedAttributes.size () > 0 )
  {
    doUpdate = true;
  }

  if ( doUpdate )
  {
    _registeredHive->notifyDataUpdate ( this, value, changedAttributes );
  }
}
