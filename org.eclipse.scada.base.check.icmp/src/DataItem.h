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
#ifndef DATAITEM_H_
#define DATAITEM_H_

class DataItem;

#include "headers.h"
#include "Hive.h"

/**
 * @class DataItem
 * @brief A data item implementation
 */
class DataItem
{
public:

  enum { INPUT = 1, OUTPUT = 2 } IODirection;

  DataItem ( const std::string & id, int ioDirections );
  virtual ~DataItem ();

  std::string id () const;
  int ioDirections () const;

  void setHive ( Hive * hive );

  void updateValue ( std::auto_ptr<std::string> value, std::map<std::string, std::string> attributes );
  void updateValue ( const std::string & value );

private:

  std::string _id;
  int _ioDirections;

  Hive * _registeredHive;

  std::string * _lastValue;

  std::map<std::string,std::string> _lastAttributes;
};

#endif /* DATAITEM_H_ */
