#!/bin/bash

USER=neoscada

. /etc/default/$USER
exec esDriverExporter "@@driverName@@" -attach