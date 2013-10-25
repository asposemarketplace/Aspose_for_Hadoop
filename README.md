Aspose For Hadoop
=================

Aspose for Hadoop project enables Hadoop developers to work with binary file formats. The Hadoop / MR developers can use this project to convert binary sequence files into text sequence files. The text can then be used for analysis purpose in MapReduce algorithms.

Packages
--------
com.aspose.hadoop.core

      Provides Aspose for Java wrapper classes to parse binary formats into text. The package also includes a couple of classed to override Hadoop input formats so as to be used for creating binary sequence files.
com.aspose.hadoop.examples 
      
      Provides mapper examples for a converting binary sequence file(s) into text sequence file(s). Each mapper example takes a particular set of binary format as exaplained in the next section.

Mapper Examples Flow and Usage
------------------------------

CreateBinarySequence

      Picks up the set of files from an HDFS directory, create binary sequence file(s) and stores the binary sequence file(s) to an HDFS directory.
      Usage: [HADOOP_HOME]$ bin/hadoop jar AsposeForHadoop.jar CreateBinarySequence <HDFS input directory> <HDFS output directory>
CreateDocumentTextSequence

      Picks up binary sequence file(s) generated from documents (MS Words / OpenOffice docs), parses text from the documents, creates a text sequence file and stores this text sequence file to an HDFS directory.
      Usage: [Hadoop_HOME]$ bin/hadoop jar AsposeForHadoop.jar CreateDocumentTextSequence <HDFS input directory> <HDFS output directory>
      Tip: Put your documents in an HDFS directory, use CreateBinarySequence mapper to generate binary sequence file. Finally supply output directory of this mapper as an input here.
CreateSpreadSheetTextSequence

      Picks up binary sequence file(s) generated from spreadsheets (MS Excel / OpenOffice spreadsheets), parses text from the spreadsheets, creates a text sequence file and stores this text sequence file to an HDFS directory.
      Usage: [Hadoop_HOME]$ bin/hadoop jar AsposeForHadoop.jar CreateSpreadSheetTextSequence <HDFS input directory> <HDFS output directory>
      Tip: Put your spreadsheets in an HDFS directory, use CreateBinarySequence mapper to generate binary sequence file. Finally supply output directory of this mapper as an input here.
CreatePresentationTextSequence

      Picks up binary sequence file(s) generated from presentation (MS PoerPoint PPTX presentations), parses text from the presentations, creates a text sequence file and stores this text sequence file to an HDFS directory.
      Usage: [Hadoop_HOME]$ bin/hadoop jar AsposeForHadoop.jar CreatePresentationTextSequence <HDFS input directory> <HDFS output directory>
      Tip: Put your PPTX presentations in an HDFS directory, use CreateBinarySequence mapper to generate binary sequence file. Finally supply output directory of this mapper as an input here.
CreateEmailTextSequence

      Picks up binary sequence file(s) generated from emails (msg emails), parses text from the msg files, creates a text sequence file and stores this text sequence file to an HDFS directory.
      Usage: [Hadoop_HOME]$ bin/hadoop jar AsposeForHadoop.jar CreateEmailTextSequence <HDFS input directory> <HDFS output directory>
      Tip: Put your PPTX presentations in an HDFS directory, use CreateBinarySequence mapper to generate binary sequence file. Finally supply output directory of this mapper as an input here.

Aspose: www.aspose.com
