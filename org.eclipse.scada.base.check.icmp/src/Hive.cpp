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
#include "Hive.h"

Hive::Hive ( std::ostream & outStream ) :
  outStream ( outStream )
{
}

Hive::~Hive ()
{
}

void Hive::registerItem ( DataItem * dataItem )
{
  dataItem->setHive ( this );
  outStream << "REGISTER/" + dataItem->id () << std::endl;
}

void Hive::unregisterItem ( DataItem * dataItem )
{
  dataItem->setHive ( NULL );
  outStream << "UNREGISTER/" + dataItem->id () << std::endl;
}

void Hive::notifyDataUpdate ( DataItem * item, std::auto_ptr<std::string> value, std::map<std::string, std::string> attributes )
{
  outStream << "DATA-CHANGED/" << item->id () << "/";
  if ( value.get () != NULL )
  {
    outStream << *value;
  }
  outStream << "/";
  for ( std::map<std::string, std::string>::iterator i = attributes.begin (); i != attributes.end (); i++ )
  {
    outStream << i->first << "=" << i->second << "/";
  }
  outStream << std::endl;
}
