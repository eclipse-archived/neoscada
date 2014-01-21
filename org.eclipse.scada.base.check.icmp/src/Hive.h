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
#ifndef HIVE_H_
#define HIVE_H_

#include "headers.h"

class Hive;

#include "DataItem.h"

class Hive
{
public:
  Hive ( std::ostream & outStream );
  virtual ~Hive ();

  virtual void registerItem ( DataItem * dataItem );
  virtual void unregisterItem ( DataItem * dataItem );

  virtual void notifyDataUpdate ( DataItem * item, std::auto_ptr<std::string> value, std::map<std::string, std::string> attributes );

private:
  std::ostream & outStream;
};

#endif /* HIVE_H_ */
