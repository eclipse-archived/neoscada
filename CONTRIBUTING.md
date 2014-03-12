Contributing to Eclipse SCADA
=============================

Thanks for your interest in this project.

Project description:
--------------------

SCADA (supervisory control and data acquisition) is a type of industrial control system (ICS). Industrial control systems are computer controlled systems that monitor and control industrial processes that exist in the physical world. SCADA systems historically distinguish themselves from other ICS systems by being large scale processes that can include multiple sites, and large distances.
Simply speaking the primary target of Eclipse SCADA is a way to connect different industrial devices to a common communication system and post-process as well as visualize the data to operating personnel.
Since this scheme will also work with non-industrial devices and devices do become more complex and tend to become software solutions themselves the term "device" should be more considered as an "other system".
The idea of a SCADA system is to provide mostly scalar values instead of complex data structures. Where necessary data structures are split up into multiple scalar values. This is done in order to process the data more quickly and allow common processing of data.
For example a meteo station is providing current weather information. It can provide temperature and solar radiation. These are two floating point values which are processed independently. Still the same alarming schema (high level alarm) can be applied to both values. The values can both be assigned a quality/alarm information (alarm state) which can then be shown using the same user interface element and the same visualization scheme (alarm is displayed with red background). This way many different scalar values can be processed exactly the same way.

- https://projects.eclipse.org/projects/technology.eclipsescada

Developer resources:
--------------------

Information regarding source code management, builds, coding standards, and more.

- https://projects.eclipse.org/projects/technology.eclipsescada/developer
- https://wiki.eclipse.org/EclipseSCADA/Contributing

Contributor License Agreement:
------------------------------

Before your contribution can be accepted by the project, you need to create and electronically sign the Eclipse Foundation Contributor License Agreement (CLA).

- http://www.eclipse.org/legal/CLA.php

Contact:
--------

Contact the project developers via the project's "dev" list.

- https://dev.eclipse.org/mailman/listinfo/scada-dev

Search for bugs:
----------------

This project uses Bugzilla to track ongoing development and issues.

- https://bugs.eclipse.org/bugs/buglist.cgi?product=Scada

Create a new bug:
-----------------

Be sure to search for existing bugs before you create another one. Remember that contributions are always welcome!

- https://bugs.eclipse.org/bugs/enter_bug.cgi?product=Scada

