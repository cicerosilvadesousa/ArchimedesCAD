#!/bin/sh
TMP_DIR=download_all_tmp
LS_FILE=ls.txt
CO_FILE=co.sh
GEN_FILE=gen_build.sh
BIN=bin
mkdir -p $TMP_DIR/$BIN
svn list https://incubadora.fapesp.br/svn/archimedes/mainarchimedes/rcparchimedes/ > $TMP_DIR/$LS_FILE
echo '#!/bin/sh' > $TMP_DIR/$CO_FILE
sed 's/$/trunk/' $TMP_DIR/$LS_FILE | sed 's/^/svn co https:\/\/incubadora.fapesp.br\/svn\/archimedes\/mainarchimedes\/rcparchimedes\//' | sed 's/\(rcparchimedes\/\(.*\)\/trunk\)/\1 \2/' >> $TMP_DIR/$CO_FILE
chmod +x $TMP_DIR/$CO_FILE

cd $TMP_DIR/$BIN
../$CO_FILE 
echo '#!/bin/sh\nECLIPSE_HOME=/Applications/eclipse\n' > $GEN_FILE
#sed 's/^/cd /' ../$LS_FILE | sed 's/$/;java -cp $ECLIPSE_HOME\/startup.jar org.eclipse.core.launcher.Main -application org.eclipse.ant.core.antRunner -buildfile build.xml;cd ../'>> $GEN_FILE
#chmod +x $GEN_FILE
#cat $GEN_FILE
cd ..
ls -R1 *.java | wc

#rm -Rf $TMP_DIR/