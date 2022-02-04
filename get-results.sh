#!/bin/bash                                                                                                                                                                              
 
if [ -z "$1" ]
then
  printf "❌ No lab name given! Try running something like \"bash get-results.sh Lab1\"\n"
  exit 1
fi
 
if [ ! -d "inputs" ]; then
  printf "❌ No input folder!\n"
  exit 1
fi
 
if [ ! -d "outputs" ]; then
  printf "❌ No output folder!\n"
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
  printf "❌ Compilation error!\nMake sure that your .java files can compile!\n🔧 Run \"vim compilation_errors.txt\" to see what you need to fix!\n"
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
    printf "⚠️ test $i failed!\nrun the following command\n  ⌨️  vim -d results/$lab_name.$i.results outputs/$lab_name.$i.out ⌨️\nto see the difference between the expected output and your program's output!"
    (( num_testcases_failed = num_testcases_failed + 1 ))
  else
    printf "✅ test $i passed!\n"
    rm results/$lab_name.$i.results
  fi
done
 
if (( num_testcases_failed > 0 )); then
  printf "\n🔧🔧🔧 your program did not pass some test-cases! run the aforementioned commands to see where it went wrong! keep going! 🔧🔧🔧\n"
else
  printf "\n🎉🎉🎉 awesome! your program passed all the given test-cases! 🎉🎉🎉\n"
fi
