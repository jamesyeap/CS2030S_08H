#!/bin/bash                                                                                                                                                                              
 
if [ -z "$1" ]
then
  printf "ā No lab name given! Try running something like \"bash get-results.sh Lab1\"\n"
  exit 1
fi
 
if [ ! -d "inputs" ]; then
  printf "ā No input folder!\n"
  exit 1
fi
 
if [ ! -d "outputs" ]; then
  printf "ā No output folder!\n"
  exit 1
fi
 
lab_name=$1
num_testcases=`ls inputs/ | wc -l`
 
# recompile all .java files for the lab
rm -f *.class
rm -f compilation_errors.txt
javac $lab_name.java 2> compilation_errors.txt
 
if [ ! $? -eq 0 ]; then
  # check if .java files have any compilation errors, and exits if so
  printf "ā Compilation error!\nMake sure that your .java files can compile!\nš§ Run \"vim compilation_errors.txt\" to see what you need to fix!\n"
  exit 1
fi
 
# create a new folder called "results" if one doesn't exist yet
if [ ! -d "results" ]; then
  mkdir results
fi
 
declare -i num_testcases_failed=0
 
for ((i = 1; i<= $num_testcases; i++)); do
  java $lab_name < inputs/$lab_name.$i.in > results/$lab_name.$i.results
 
  if ! cmp -s "results/$lab_name.$i.results" "outputs/$lab_name.$i.out"; then
    printf "ā ļø test $i failed!\nrun the following command\n  āØļø  vim -d results/$lab_name.$i.results outputs/$lab_name.$i.out āØļø\nto see the difference between the expected output and your program's output!"
    (( num_testcases_failed = num_testcases_failed + 1 ))
  else
    printf "ā test $i passed!\n"
    rm results/$lab_name.$i.results
  fi
done
 
if (( num_testcases_failed > 0 )); then
  printf "\nš§š§š§ your program did not pass some test-cases! run the aforementioned commands to see where it went wrong! keep going! š§š§š§\n"
else
  printf "\nššš awesome! your program passed all the given test-cases! ššš\n"
fi
