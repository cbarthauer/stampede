MumpsAnalyzer
=============
MumpsAnalyzer is a static analysis framework for the MUMPS programming language. It
analyzes MUMPS source code and calculates code quality metrics. In addition, it 
provides a plugin for displaying the results using the [Sonar](http://www.sonarsource.org)
framework. 

For screenshots, proposed features, and project 
progress, please take a look at the 
[MumpsAnalyzer Trello Board](https://trello.com/board/mumpsanalyzer/5156fd731b8e840f31001285).

Demo
----
To view a live demo of this tool, visit http://mumpsanalyzer-cbarthauer.rhcloud.com/.

Additionally, the demo folder contains a fully-functional Sonar distribution with MumpsAnalyzer 
installed. The demo includes MUMPS code from both the [FLAP Fileman Project] 
(https://github.com/OSEHRA/fileman-22p2) and [OSEHRA's VistA-FOIA]
(https://github.com/OSEHRA/VistA-FOIA?source=cr). The following packages 
from VistA-FOIA are preloaded:

1. Accounts Receivable
2. Integrated Billing
3. Order Entry Results Reporting
4. Toolkit
5. Uncategorized

Viewing the demo is very easy:

1. Unzip demo/sonar-mumps-demo-3.5.1.zip
2. On Windows, run bin/windows-x86-64/StartSonar.bat
3. In a browser, go to http://localhost:9000

Current Features
----------------
1. Duplication Detection - MumpsAnalyzer integrates with Sonar's copy-paste detection
system to detect duplication within MUMPS source code.
2. Lines of Code Metric - MumpsAnalyzer counts physical lines of code.
3. Non-Comment Lines of Code Metric - MumpsAnalyzer counts non-comment lines of code. These
are lines containing some executable code (i.e., excludes lines containing only a
comment).
4. Violations - MumpsAnalyzer supports limited detection of syntax errors. Syntax errors 
are reported using Sonar's violation mechanism.
5. Sonar GUI - MumpsAnalyzer displays all results within the Sonar web-based
GUI. All metrics are integrated with Sonar's drilldown display to report results at the 
distribution, module, and file levels.
 
Technical Details
-----------------
1. MumpsAnalyzer uses [ANTLR 4](http://www.antlr.org) to parse MUMPS code. The ANTLR grammar 
file is available in the grammar folder: grammar/M.g4. The grammar is incomplete; it only 
includes enough detail to support the proof-of-concept functionality.
2. MumpsAnalyzer is developed according to the 
[VA Java Coding Standard](http://www.va.gov/TRM/files/Java_Coding_Standards_V2.doc).

Contact Information
-------------------
MumpsAnalyzer is developed by Chris Barthauer. If you have questions or comments about this
project, please send Chris an email at mumpsanalyzer@gmail.com.
