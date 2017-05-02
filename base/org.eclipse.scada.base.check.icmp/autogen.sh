#!/bin/bash

autoheader
aclocal
autoconf
automake --add-missing --copy

