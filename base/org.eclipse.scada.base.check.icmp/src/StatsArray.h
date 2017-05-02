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
#ifndef STATSARRAY_H_
#define STATSARRAY_H_

#include "headers.h"

template<typename T>
class StatsArray
{
public:
  StatsArray ( uint32_t samples );
  virtual ~StatsArray ();

  virtual void push ( const T & sample );

  template <typename R>
  R average ( const R & initial ) const;
  template <typename R>
  R sum ( const R & initial ) const;

  bool isValid () const;

private:
  uint32_t samples;
  uint32_t activeSamples;
  uint32_t head;
  T * sampleData;
};

template<typename T>
StatsArray<T>::StatsArray ( uint32_t samples ) :
  samples ( samples ), activeSamples ( 0 ), head ( 0 ), sampleData ( new T[samples] )
{
}

template<typename T>
StatsArray<T>::~StatsArray ()
{
  delete sampleData;
}

template<typename T>
void StatsArray<T>::push ( const T & sample )
{
  if ( activeSamples < samples )
  {
    activeSamples++;
  }
  sampleData[head] = sample;
  head++;
  if ( head >= samples )
  {
    head = 0;
  }
}

template<typename T>
template<typename R>
R StatsArray<T>::average ( const R & initial ) const
{
  return sum ( initial ) / ((R)activeSamples);
}

template<typename T>
template<typename R>
R StatsArray<T>::sum ( const R & initial ) const
{
  R result = initial;
  for ( uint32_t i = 0; i < activeSamples; i++ )
  {
    result += ((R)sampleData[i]);
  }
  return result;
}

template<typename T>
bool StatsArray<T>::isValid () const
{
  return activeSamples > samples / 2;
}

#endif /* STATSARRAY_H_ */
