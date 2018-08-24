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

; Method factorial
define i32 @Main_factorial(%struct.Main*, i32) #0 {
	; Formals
	%3 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %3
	%4 = alloca i32
	store i32 %1, i32* %4
	
	; If
	; ObjectIdentifier
	%5 = load i32, i32* %4

	; VarValue
	%6 = alloca i32
	store i32 2, i32* %6
	%7 = load i32, i32* %6
	
	; Lower
	%8 = icmp slt i32 %5, %7

	br i1 %8, label %condIf1, label %condElse1	

	condIf1:
		; VarValue
		%9 = alloca i32
		store i32 1, i32* %9
		%10 = load i32, i32* %9
		
		br label %condEnd1

	condElse1:
		; ObjectIdentifier
		%11 = load i32, i32* %4

		; Call Method
		%12 = load %struct.Main*, %struct.Main** %3
		; Arguments
		; ObjectIdentifier
		%13 = load i32, i32* %4

		; VarValue
		%14 = alloca i32
		store i32 1, i32* %14
		%15 = load i32, i32* %14
		
		; Subtraction
		%16 = sub nsw i32 %13, %15
		%17 = alloca i32
		store i32 %16, i32* %17
		%18 = load i32, i32* %17

		%19 = call i32 @Main_factorial(%struct.Main* %12, i32 %18)

		; Multiplication
		%20 = mul nsw i32 %11, %19
		%21 = alloca i32
		store i32 %20, i32* %21
		%22 = load i32, i32* %21

		br label %condEnd1

	condEnd1:
		%23 = phi i32 [%10, %condIf1], [%22, %condElse1]

	ret i32 %23
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
	%6 = call noalias i8* @malloc(i64 46) #3
	%7 = bitcast i8* %6 to [46 x i8]*
	store [46 x i8] c"Enter an integer greater-than or equal to 0:\0a\00", [46 x i8]* %7
	
	%8 = call %struct.IO* @IO_print(%struct.IO* %5, i8* %6)

	; Let
	%9 = alloca i32
	; VarValue
	%10 = alloca i32
	store i32 7, i32* %10
	%11 = load i32, i32* %10
	
	store i32 %11, i32* %9
	; If
	; ObjectIdentifier
	%12 = load i32, i32* %9

	; VarValue
	%13 = alloca i32
	store i32 0, i32* %13
	%14 = load i32, i32* %13
	
	; Lower
	%15 = icmp slt i32 %12, %14

	br i1 %15, label %condIf1, label %condElse1	

	condIf1:
			; Call Method
			%16 = load %struct.Main*, %struct.Main** %2
			%17 = getelementptr inbounds %struct.Main, %struct.Main* %16, i32 0, i32 0
			; Arguments
			; VarValue
			%18 = call noalias i8* @malloc(i64 51) #3
			%19 = bitcast i8* %18 to [51 x i8]*
			store [51 x i8] c"Error: number must be greater-than or equal to 0.\0a\00", [51 x i8]* %19
			
			%20 = call %struct.IO* @IO_print(%struct.IO* %17, i8* %18)

			; VarValue
			%21 = alloca i32
			store i32 1, i32* %21
			%22 = load i32, i32* %21
			
			; Negative
			%23 = sub nsw i32 0, %22
			%24 = alloca i32
			store i32 %23, i32* %24
			%25 = load i32, i32* %24

		br label %condEnd1

	condElse1:
			; Call Method
			%26 = load %struct.Main*, %struct.Main** %2
			%27 = getelementptr inbounds %struct.Main, %struct.Main* %26, i32 0, i32 0
			; Arguments
			; VarValue
			%28 = call noalias i8* @malloc(i64 18) #3
			%29 = bitcast i8* %28 to [18 x i8]*
			store [18 x i8] c"The factorial of \00", [18 x i8]* %29
			
			%30 = call %struct.IO* @IO_print(%struct.IO* %27, i8* %28)
			; Arguments
			; ObjectIdentifier
			%31 = load i32, i32* %9

			%32 = call %struct.IO* @IO_printInt32(%struct.IO* %30, i32 %31)
			; Arguments
			; VarValue
			%33 = call noalias i8* @malloc(i64 5) #3
			%34 = bitcast i8* %33 to [5 x i8]*
			store [5 x i8] c" is \00", [5 x i8]* %34
			
			%35 = call %struct.IO* @IO_print(%struct.IO* %32, i8* %33)

			; Call Method
			%36 = load %struct.Main*, %struct.Main** %2
			%37 = getelementptr inbounds %struct.Main, %struct.Main* %36, i32 0, i32 0
			; Arguments
			; Call Method
			%38 = load %struct.Main*, %struct.Main** %2
			; Arguments
			; ObjectIdentifier
			%39 = load i32, i32* %9

			%40 = call i32 @Main_factorial(%struct.Main* %38, i32 %39)

			%41 = call %struct.IO* @IO_printInt32(%struct.IO* %37, i32 %40)
			; Arguments
			; VarValue
			%42 = call noalias i8* @malloc(i64 2) #3
			%43 = bitcast i8* %42 to [2 x i8]*
			store [2 x i8] c"\0a\00", [2 x i8]* %43
			
			%44 = call %struct.IO* @IO_print(%struct.IO* %41, i8* %42)

			; VarValue
			%45 = alloca i32
			store i32 0, i32* %45
			%46 = load i32, i32* %45
			
		br label %condEnd1

	condEnd1:
		%47 = phi i32 [%25, %condIf1], [%46, %condElse1]

	
	ret i32 %47
}

