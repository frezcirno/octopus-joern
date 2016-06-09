#!/bin/bash

BASEDIR=$(dirname "$0")

rm -rf .testDB

java -cp "$BASEDIR/build/libs/joern.jar:$BASEDIR/jars/*" tools.parser.ParserMain testCode -outdir .testDB

# Taint sources

java -cp "$BASEDIR/build/libs/joern.jar:$BASEDIR/jars/*" tools.argumentTainter.ArgumentTainterMain -dbdir .testDB taint_source 1
java -cp "$BASEDIR/build/libs/joern.jar:$BASEDIR/jars/*" tools.argumentTainter.ArgumentTainterMain -dbdir .testDB second_taint_source 0
java -cp "$BASEDIR/build/libs/joern.jar:$BASEDIR/jars/*" tools.argumentTainter.ArgumentTainterMain -dbdir .testDB interproc_callee 0
