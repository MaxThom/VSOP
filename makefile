all:
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi
	mkdir tmp$(FILE)
	llvm-as -f $(FILE).ll -o tmp$(FILE)/$(FILE).bc
	llc tmp$(FILE)/$(FILE).bc
	gcc -c tmp$(FILE)/$(FILE).s -o tmp$(FILE)/$(FILE).o -no-pie
	gcc tmp$(FILE)/$(FILE).o -o tmp$(FILE)/$(FILE) -no-pie
	echo ----
	./tmp$(FILE)/$(FILE)
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi

emit:
	clang -O0 -S -emit-llvm $(FILE)

exec:
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi
	mkdir tmp$(FILE)
	llvm-as -f $(FILE).ll -o tmp$(FILE)/$(FILE).bc
	llc tmp$(FILE)/$(FILE).bc
	gcc -c tmp$(FILE)/$(FILE).s -o tmp$(FILE)/$(FILE).o -no-pie
	gcc tmp$(FILE)/$(FILE).o -o $(FILE) -no-pie
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi
	echo ----
	./$(FILE)

exec_keep_tmp:
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi
	mkdir tmp$(FILE)
	llvm-as -f VSOP_Executable/$(FILE).ll -o tmp$(FILE)/$(FILE).bc
	llc tmp$(FILE)/$(FILE).bc
	gcc -c tmp$(FILE)/$(FILE).s -o tmp$(FILE)/$(FILE).o -no-pie
	gcc tmp$(FILE)/$(FILE).o -o VSOP_Executable/$(FILE) -no-pie
	echo ----
	./$(FILE)

generate:
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi
	mkdir tmp$(FILE)
	llvm-as -f $(FILE).ll -o tmp$(FILE)/$(FILE).bc
	llc tmp$(FILE)/$(FILE).bc
	gcc -c tmp$(FILE)/$(FILE).s -o tmp$(FILE)/$(FILE).o -no-pie
	gcc tmp$(FILE)/$(FILE).o -o $(FILE) -no-pie
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi

generateVSOP:
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi
	mkdir tmp$(FILE)
	llvm-as -f VSOP_Executable/$(FILE).ll -o tmp$(FILE)/$(FILE).bc
	llc tmp$(FILE)/$(FILE).bc
	gcc -c tmp$(FILE)/$(FILE).s -o tmp$(FILE)/$(FILE).o -no-pie
	gcc tmp$(FILE)/$(FILE).o -o VSOP_Executable/$(FILE) -no-pie
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi

generateExecuteVSOP:
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi
	mkdir tmp$(FILE)
	llvm-as -f VSOP_Executable/$(FILE).ll -o tmp$(FILE)/$(FILE).bc
	llc tmp$(FILE)/$(FILE).bc
	gcc -c tmp$(FILE)/$(FILE).s -o tmp$(FILE)/$(FILE).o -no-pie
	gcc tmp$(FILE)/$(FILE).o -o VSOP_Executable/$(FILE) -no-pie
	if [ -d "./tmp$(FILE)" ];then     \
		rm -r tmp$(FILE);             \
	fi
	./VSOP_Executable/$(FILE)
