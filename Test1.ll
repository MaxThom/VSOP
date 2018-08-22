; ModuleID = 'Test1.vsop'
; 
; DECLARATION
; 
declare noalias i8* @malloc(i64) #1
declare i32 @printf(i8*, ...)
declare double @pow(double, double) #1
declare i32 @strcmp(i8*, i8*) #1
declare i32 @__isoc99_scanf(i8*, ...) #1
declare i8* @fgets(i8*, i32, %struct._IO_FILE*) #2
%struct._IO_FILE = type { i32, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, i8*, %struct._IO_marker*, %struct._IO_FILE*, i32, i32, i64, i16, i8, [1 x i8], i8*, i64, i8*, i8*, i8*, i8*, i64, i32, [20 x i8] }
%struct._IO_marker = type { %struct._IO_marker*, %struct._IO_FILE*, i32 }
@stdin = external global %struct._IO_FILE*, align 8
declare void @exit(i32) #1
@.str.empty = private unnamed_addr constant [1 x i8] zeroinitializer, align 1

; 
; STRUCTURES
; 
%struct.Object = type { }
%struct.IO = type {
	%struct.Object
}
%struct.Main = type {
	%struct.IO
}

; 
; Object Class

; 
; Allocation
define %struct.Object* @Object.new() #0 {
	%1 = alloca %struct.Object*
	%2 = call noalias i8* @malloc(i64 0) #3
	%3 = bitcast i8* %2 to %struct.Object*
	store %struct.Object* %3, %struct.Object** %1
	%4 = load %struct.Object*, %struct.Object** %1
	ret %struct.Object* %4
}

; Initializer
define void @Object.init(%struct.Object*) #0 { ret void }


; 
; IO Class

; 
; Allocation
define %struct.IO* @IO.new() #0 {
	%1 = alloca %struct.IO*
	%2 = call noalias i8* @malloc(i64 0) #3
	%3 = bitcast i8* %2 to %struct.IO*
	store %struct.IO* %3, %struct.IO** %1
	%4 = load %struct.IO*, %struct.IO** %1
	ret %struct.IO* %4
}

; Initializer
define void @IO.init(%struct.IO*) #0 { ret void }

@IO.printInt = private constant [3 x i8] c"%d\00"
@IO.printStr = private constant [3 x i8] c"%s\00"
@IO.printBool = private constant [3 x i8] c"%d\00"
@IO.printlnInt = private constant [4 x i8] c"%d\0A\00"
@IO.printlnStr = private constant [4 x i8] c"%s\0A\00"
@IO.printlnBool = private constant [4 x i8] c"%d\0A\00"
@IO.inputInt = private constant [3 x i8] c"%d\00"
@IO.inputStr = private constant [3 x i8] c"%s\00"

define %struct.IO* @IO_printInt32(%struct.IO*, i32) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printInt, i32 0, i32 0), i32 %1)
	ret %struct.IO* %0
}
define %struct.IO* @IO_printBool(%struct.IO*, i1) {
	%3 = icmp eq i1 %1, 0
	br i1 %3, label %false, label %true	

    true:
        %msg = alloca [5 x i8]
        store [5 x i8] c"true\00", [5 x i8]* %msg
        %loadedMsg = bitcast [5 x i8]* %msg to i8*
        call %struct.IO* @IO_print(%struct.IO* %0, i8* %loadedMsg)
        br label %end

    false:
        %msg2 = alloca [6 x i8]
        store [6 x i8] c"false\00", [6 x i8]* %msg2
        %loadedMsg2 = bitcast [6 x i8]* %msg2 to i8*
        call %struct.IO* @IO_print(%struct.IO* %0, i8* %loadedMsg2)
        br label %end

	end:
	    ret %struct.IO* %0
}
define %struct.IO* @IO_print(%struct.IO*, i8*) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printStr, i32 0, i32 0), i8* %1)
	ret %struct.IO* %0
}
define %struct.IO* @IO_printlnInt32(%struct.IO*, i32) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnInt, i32 0, i32 0), i32 %1)
	ret %struct.IO* %0
}
define %struct.IO* @IO_printlnBool(%struct.IO*, i1) {
	%3 = icmp eq i1 %1, 0
	br i1 %3, label %false, label %true	

    true:
        %msg = alloca [5 x i8]
        store [5 x i8] c"true\00", [5 x i8]* %msg
        %loadedMsg = bitcast [5 x i8]* %msg to i8*
        call %struct.IO* @IO_println(%struct.IO* %0, i8* %loadedMsg)
        br label %end

    false:
        %msg2 = alloca [6 x i8]
        store [6 x i8] c"false\00", [6 x i8]* %msg2
        %loadedMsg2 = bitcast [6 x i8]* %msg2 to i8*
        call %struct.IO* @IO_println(%struct.IO* %0, i8* %loadedMsg2)
        br label %end

	end:
	    ret %struct.IO* %0
}
define %struct.IO* @IO_println(%struct.IO*, i8*) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnStr, i32 0, i32 0), i8* %1)
	ret %struct.IO* %0
}
define i32 @IO_inputInt32(%struct.IO*) {
    %2 = alloca i32, align 4
    %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputInt, i32 0, i32 0), i32* %2)
    %4 = load i32, i32* %2

    %5 = icmp eq i32 %3, 0
    br i1 %5, label %exit, label %end

    exit:
        %msg = alloca [40 x i8]
        store [40 x i8] c"Error : invalid input. Expecting int32.\00", [40 x i8]* %msg
        %loadedMsg = bitcast [40 x i8]* %msg to i8*
        call %struct.IO* @IO_println(%struct.IO* %0, i8* %loadedMsg)
        call void @exit(i32 1) #3
        br label %end

    end:
	    ret i32 %4
}
define i1 @IO_inputBool(%struct.IO*) {
    %2 = alloca i32, align 4
    %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputInt, i32 0, i32 0), i32* %2)
    %4 = load i32, i32* %2

    %5 = icmp eq i32 %3, 0
    br i1 %5, label %exit, label %end

    exit:
        %msg = alloca [49 x i8]
        store [49 x i8] c"Error : invalid input. Expecting boolean 1 or 0.\00", [49 x i8]* %msg
        %loadedMsg = bitcast [49 x i8]* %msg to i8*
        call %struct.IO* @IO_println(%struct.IO* %0, i8* %loadedMsg)
        call void @exit(i32 1) #3
        br label %end

    end:
        %7 = icmp ne i32 %4, 0
	    ret i1 %7
}
define i8* @IO_inputLine(%struct.IO*) {
    %2 = alloca [1024 x i8]
    %3 = getelementptr inbounds [1024 x i8], [1024 x i8]* %2, i32 0, i32 0
    %4 = load %struct._IO_FILE*, %struct._IO_FILE** @stdin
    %5 = call i8* @fgets(i8* %3, i32 1024, %struct._IO_FILE* %4)
    %6 = bitcast [1024 x i8]* %2 to i8*

    ret i8* %6
}


; 
; MAIN
; 

; Allocation
define %struct.Main* @Main.new() #0 {
	%size_as_ptr = getelementptr %struct.Main, %struct.Main* null, i32 1
	%size_as_i64 = ptrtoint %struct.Main* %size_as_ptr to i64

	%1 = alloca %struct.Main*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.Main*
	store %struct.Main* %3, %struct.Main** %1

	%4 = load %struct.Main*, %struct.Main** %1
	call void @Main.init(%struct.Main* %4)

	%5 = load %struct.Main*, %struct.Main** %1
	ret %struct.Main* %5
}

; Initializer
define void @Main.init(%struct.Main*) #0 {
	%2 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %2

	%3 = load %struct.Main*, %struct.Main** %2
	%4 = getelementptr inbounds %struct.Main, %struct.Main* %3, i32 0, i32 0
	call void @IO.init(%struct.IO* %4)

	ret void
}

; Method main
define i32 @main(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	%3 = call %struct.Main* @Main.new()
	store %struct.Main* %3, %struct.Main** %2
	
	; Call Method
	%4 = load %struct.Main*, %struct.Main** %2
	%5 = getelementptr inbounds %struct.Main, %struct.Main* %4, i32 0, i32 0
	; Arguments
	; VarValue
	%6 = alloca [17 x i8]
	store [17 x i8] c"Enter a string:\0a\00", [17 x i8]* %6
	%7 = bitcast [17 x i8]* %6 to i8*
	
	%8 = call %struct.IO* @IO_print(%struct.IO* %5, i8* %7)

	; Let
	%9 = alloca i8*
	; Call Method
	%10 = load %struct.Main*, %struct.Main** %2
	%11 = getelementptr inbounds %struct.Main, %struct.Main* %10, i32 0, i32 0
	%12 = call i8* @IO_inputLine(%struct.IO* %11)

	store i8* %12, i8** %9
	; Call Method
	%13 = load %struct.Main*, %struct.Main** %2
	%14 = getelementptr inbounds %struct.Main, %struct.Main* %13, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%15 = load i8*, i8** %9

	%16 = call %struct.IO* @IO_print(%struct.IO* %14, i8* %15)

	
	; Call Method
	%17 = load %struct.Main*, %struct.Main** %2
	%18 = getelementptr inbounds %struct.Main, %struct.Main* %17, i32 0, i32 0
	; Arguments
	; VarValue
	%19 = alloca [17 x i8]
	store [17 x i8] c"Enter a number:\0a\00", [17 x i8]* %19
	%20 = bitcast [17 x i8]* %19 to i8*
	
	%21 = call %struct.IO* @IO_print(%struct.IO* %18, i8* %20)

	; Let
	%22 = alloca i32
	; Call Method
	%23 = load %struct.Main*, %struct.Main** %2
	%24 = getelementptr inbounds %struct.Main, %struct.Main* %23, i32 0, i32 0
	%25 = call i32 @IO_inputInt32(%struct.IO* %24)

	store i32 %25, i32* %22
	; Call Method
	%26 = load %struct.Main*, %struct.Main** %2
	%27 = getelementptr inbounds %struct.Main, %struct.Main* %26, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%28 = load i32, i32* %22

	%29 = call %struct.IO* @IO_printInt32(%struct.IO* %27, i32 %28)

	
	; Call Method
	%30 = load %struct.Main*, %struct.Main** %2
	%31 = getelementptr inbounds %struct.Main, %struct.Main* %30, i32 0, i32 0
	; Arguments
	; VarValue
	%32 = alloca [19 x i8]
	store [19 x i8] c"\0aEnter a boolean:\0a\00", [19 x i8]* %32
	%33 = bitcast [19 x i8]* %32 to i8*
	
	%34 = call %struct.IO* @IO_print(%struct.IO* %31, i8* %33)

	; Let
	%35 = alloca i1
	; Call Method
	%36 = load %struct.Main*, %struct.Main** %2
	%37 = getelementptr inbounds %struct.Main, %struct.Main* %36, i32 0, i32 0
	%38 = call i1 @IO_inputBool(%struct.IO* %37)

	store i1 %38, i1* %35
	; Call Method
	%39 = load %struct.Main*, %struct.Main** %2
	%40 = getelementptr inbounds %struct.Main, %struct.Main* %39, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%41 = load i1, i1* %35

	%42 = call %struct.IO* @IO_printBool(%struct.IO* %40, i1 %41)

	
	; Call Method
	%43 = load %struct.Main*, %struct.Main** %2
	%44 = getelementptr inbounds %struct.Main, %struct.Main* %43, i32 0, i32 0
	; Arguments
	; VarValue
	%45 = alloca [25 x i8]
	store [25 x i8] c"\0aEnter another boolean:\0a\00", [25 x i8]* %45
	%46 = bitcast [25 x i8]* %45 to i8*
	
	%47 = call %struct.IO* @IO_print(%struct.IO* %44, i8* %46)

	; Let
	%48 = alloca i1
	; Call Method
	%49 = load %struct.Main*, %struct.Main** %2
	%50 = getelementptr inbounds %struct.Main, %struct.Main* %49, i32 0, i32 0
	%51 = call i1 @IO_inputBool(%struct.IO* %50)

	store i1 %51, i1* %48
	; Call Method
	%52 = load %struct.Main*, %struct.Main** %2
	%53 = getelementptr inbounds %struct.Main, %struct.Main* %52, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%54 = load i1, i1* %48

	%55 = call %struct.IO* @IO_printBool(%struct.IO* %53, i1 %54)

	
	; Call Method
	%56 = load %struct.Main*, %struct.Main** %2
	%57 = getelementptr inbounds %struct.Main, %struct.Main* %56, i32 0, i32 0
	; Arguments
	; VarValue
	%58 = alloca [2 x i8]
	store [2 x i8] c"\0a\00", [2 x i8]* %58
	%59 = bitcast [2 x i8]* %58 to i8*
	
	%60 = call %struct.IO* @IO_print(%struct.IO* %57, i8* %59)

	; VarValue
	%61 = alloca i32
	store i32 0, i32* %61
	%62 = load i32, i32* %61
	
	ret i32 %62
}

