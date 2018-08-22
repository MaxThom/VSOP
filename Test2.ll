; ModuleID = 'Test2.vsop'
; 
; DECLARATION
; 
declare noalias i8* @malloc(i64) #1
declare i32 @printf(i8*, ...)
declare double @pow(double, double) #1
declare i32 @strcmp(i8*, i8*) #1
declare i32 @__isoc99_scanf(i8*, ...) #1
declare i8* @fgets(i8*, i32, %struct._IO_FILE*) #2
declare i8* @llvm.stacksave() #3
declare void @llvm.stackrestore(i8*) #3
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
	
	; If
		; Call Method
		%4 = load %struct.Main*, %struct.Main** %2
		%5 = getelementptr inbounds %struct.Main, %struct.Main* %4, i32 0, i32 0
		; Arguments
		; VarValue
		%6 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %6
		%7 = bitcast [4 x i8]* %6 to i8*
		
		%8 = call %struct.IO* @IO_print(%struct.IO* %5, i8* %7)

		; VarValue
		%9 = alloca i1
		store i1 1, i1* %9
		%10 = load i1, i1* %9
		
	br i1 %10, label %And1, label%condElse1
	And1:
		; Call Method
		%11 = load %struct.Main*, %struct.Main** %2
		%12 = getelementptr inbounds %struct.Main, %struct.Main* %11, i32 0, i32 0
		; Arguments
		; VarValue
		%13 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %13
		%14 = bitcast [4 x i8]* %13 to i8*
		
		%15 = call %struct.IO* @IO_print(%struct.IO* %12, i8* %14)

		; VarValue
		%16 = alloca i1
		store i1 1, i1* %16
		%17 = load i1, i1* %16
		
	; And
	%18 = and i1 %10, %17

	br i1 %18, label %condIf1, label %condElse1	

	condIf1:
		; Call Method
		%19 = load %struct.Main*, %struct.Main** %2
		%20 = getelementptr inbounds %struct.Main, %struct.Main* %19, i32 0, i32 0
		; Arguments
		; VarValue
		%21 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %21
		%22 = bitcast [4 x i8]* %21 to i8*
		
		%23 = call %struct.IO* @IO_print(%struct.IO* %20, i8* %22)

		br label %condEnd1

	condElse1:
		; Call Method
		%24 = load %struct.Main*, %struct.Main** %2
		%25 = getelementptr inbounds %struct.Main, %struct.Main* %24, i32 0, i32 0
		; Arguments
		; VarValue
		%26 = alloca [4 x i8]
		store [4 x i8] c"KO\0a\00", [4 x i8]* %26
		%27 = bitcast [4 x i8]* %26 to i8*
		
		%28 = call %struct.IO* @IO_print(%struct.IO* %25, i8* %27)

		br label %condEnd1

	condEnd1:
		%29 = phi %struct.IO* [%23, %condIf1], [%28, %condElse1]

	; If
		; Call Method
		%30 = load %struct.Main*, %struct.Main** %2
		%31 = getelementptr inbounds %struct.Main, %struct.Main* %30, i32 0, i32 0
		; Arguments
		; VarValue
		%32 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %32
		%33 = bitcast [4 x i8]* %32 to i8*
		
		%34 = call %struct.IO* @IO_print(%struct.IO* %31, i8* %33)

		; VarValue
		%35 = alloca i1
		store i1 1, i1* %35
		%36 = load i1, i1* %35
		
	br i1 %36, label %And2, label%condElse2
	And2:
		; Call Method
		%37 = load %struct.Main*, %struct.Main** %2
		%38 = getelementptr inbounds %struct.Main, %struct.Main* %37, i32 0, i32 0
		; Arguments
		; VarValue
		%39 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %39
		%40 = bitcast [4 x i8]* %39 to i8*
		
		%41 = call %struct.IO* @IO_print(%struct.IO* %38, i8* %40)

		; VarValue
		%42 = alloca i1
		store i1 0, i1* %42
		%43 = load i1, i1* %42
		
	; And
	%44 = and i1 %36, %43

	br i1 %44, label %condIf2, label %condElse2	

	condIf2:
		; Call Method
		%45 = load %struct.Main*, %struct.Main** %2
		%46 = getelementptr inbounds %struct.Main, %struct.Main* %45, i32 0, i32 0
		; Arguments
		; VarValue
		%47 = alloca [4 x i8]
		store [4 x i8] c"KO\0a\00", [4 x i8]* %47
		%48 = bitcast [4 x i8]* %47 to i8*
		
		%49 = call %struct.IO* @IO_print(%struct.IO* %46, i8* %48)

		br label %condEnd2

	condElse2:
		; Call Method
		%50 = load %struct.Main*, %struct.Main** %2
		%51 = getelementptr inbounds %struct.Main, %struct.Main* %50, i32 0, i32 0
		; Arguments
		; VarValue
		%52 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %52
		%53 = bitcast [4 x i8]* %52 to i8*
		
		%54 = call %struct.IO* @IO_print(%struct.IO* %51, i8* %53)

		br label %condEnd2

	condEnd2:
		%55 = phi %struct.IO* [%49, %condIf2], [%54, %condElse2]

	; If
		; Call Method
		%56 = load %struct.Main*, %struct.Main** %2
		%57 = getelementptr inbounds %struct.Main, %struct.Main* %56, i32 0, i32 0
		; Arguments
		; VarValue
		%58 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %58
		%59 = bitcast [4 x i8]* %58 to i8*
		
		%60 = call %struct.IO* @IO_print(%struct.IO* %57, i8* %59)

		; VarValue
		%61 = alloca i1
		store i1 0, i1* %61
		%62 = load i1, i1* %61
		
	br i1 %62, label %And3, label%condElse3
	And3:
		; Call Method
		%63 = load %struct.Main*, %struct.Main** %2
		%64 = getelementptr inbounds %struct.Main, %struct.Main* %63, i32 0, i32 0
		; Arguments
		; VarValue
		%65 = alloca [4 x i8]
		store [4 x i8] c"KO\0a\00", [4 x i8]* %65
		%66 = bitcast [4 x i8]* %65 to i8*
		
		%67 = call %struct.IO* @IO_print(%struct.IO* %64, i8* %66)

		; VarValue
		%68 = alloca i1
		store i1 1, i1* %68
		%69 = load i1, i1* %68
		
	; And
	%70 = and i1 %62, %69

	br i1 %70, label %condIf3, label %condElse3	

	condIf3:
		; Call Method
		%71 = load %struct.Main*, %struct.Main** %2
		%72 = getelementptr inbounds %struct.Main, %struct.Main* %71, i32 0, i32 0
		; Arguments
		; VarValue
		%73 = alloca [4 x i8]
		store [4 x i8] c"KO\0a\00", [4 x i8]* %73
		%74 = bitcast [4 x i8]* %73 to i8*
		
		%75 = call %struct.IO* @IO_print(%struct.IO* %72, i8* %74)

		br label %condEnd3

	condElse3:
		; Call Method
		%76 = load %struct.Main*, %struct.Main** %2
		%77 = getelementptr inbounds %struct.Main, %struct.Main* %76, i32 0, i32 0
		; Arguments
		; VarValue
		%78 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %78
		%79 = bitcast [4 x i8]* %78 to i8*
		
		%80 = call %struct.IO* @IO_print(%struct.IO* %77, i8* %79)

		br label %condEnd3

	condEnd3:
		%81 = phi %struct.IO* [%75, %condIf3], [%80, %condElse3]

	; VarValue
	%82 = alloca i32
	store i32 0, i32* %82
	%83 = load i32, i32* %82
	
	ret i32 %83
}

