MumpsAnalyzer
=============
MumpsAnalyzer is a static analysis framework for the MUMPS programming language. It
analyzes MUMPS source code and calculates code quality metrics. In addition, it 
provides a plugin for displaying the results using the [Sonar](http://www.sonarsource.org)
framework.

This project is in the proof-of-concept stage. As such, the only metric currently
implemented is lines of code. For demo screenshots, proposed features, and project 
progress, please take a look at the 
[MumpsAnalyzer Trello Board](https://trello.com/board/mumpsanalyzer/5156fd731b8e840f31001285).

Technical Details
-----------------
1. MumpsAnalyzer uses [ANTLR 4](http://www.antlr.org) to parse MUMPS code. The ANTLR grammar 
file is available in the grammar folder: grammar/M.g4. The grammar is incomplete; it only 
includes enough detail to support the proof-of-concept functionality.
2. To add a new metric, implement analyzer.MetricListener.
3. To add a new tool for parsing (or simply processing) MUMPS code, implement analyzer.RoutineProcessor.
4. To add metric results from other tools (e.g., XINDEX, etc.), implement analyzer.MetricStore.
5. MumpsAnalyzer is developed according to the 
[VA Java Coding Standard](http://www.va.gov/TRM/files/Java_Coding_Standards_V2.doc).

Demo
----
In the demo folder there is a fully-functional Sonar distribution with MumpsAnalyzer 
installed and some MUMPS code from [OSEHRA's VistA-FOIA](https://github.com/OSEHRA/VistA-FOIA?source=cr) 
preloaded. Viewing the demo is very easy:

1. Unzip demo/sonar-mumps-demo-3.5.1.zip
2. On Windows, run bin/windows-x86-64/StartSonar.bat
3. In a browser, go to http://localhost:9000

Get Involved
------------
MumpsAnalyzer is developed by Chris Barthauer. If you have questions or comments about this
project, please send Chris an email at mumpsanalyzer@gmail.com.
