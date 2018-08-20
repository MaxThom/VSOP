; ModuleID = 'Test2.vsop'
; 
; DECLARATION
; 
declare noalias i8* @malloc(i64) #1
declare i32 @printf(i8*, ...)
declare double @pow(double, double) #1
declare i32 @strcmp(i8*, i8*) #1
declare i32 @__isoc99_scanf(i8*, ...) #1declare void @exit(i32) #1@.str.empty = private unnamed_addr constant [1 x i8] zeroinitializer, align 1

; 
; STRUCTURES
; 
%struct.Object = type { }
%struct.IO = type {
	%struct.Object
}
%struct.Main = type {
	%struct.IO,
	i32
}

; 
; IO Class

; 
; Allocation
define %struct.IO* @IO_new() #0 {
	%1 = alloca %struct.IO*
	%2 = call noalias i8* @malloc(i64 0) #3
	%3 = bitcast i8* %2 to %struct.IO*
	store %struct.IO* %3, %struct.IO** %1
	%4 = load %struct.IO*, %struct.IO** %1
	ret %struct.IO* %4
}

; Initializer
define void @IO_init(%struct.IO*) #0 { ret void }

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
    %2 = alloca i8*
    %3 = load i8*, i8** %2
    
    %4 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputStr, i32 0, i32 0), i8* %3)
    %5 = load i8*, i8** %2

    ret i8* %5
}


; 
; MAIN
; 

; Allocation
define %struct.Main* @Main_new() #0 {
	%size_as_ptr = getelementptr %struct.Main, %struct.Main* null, i32 1
	%size_as_i64 = ptrtoint %struct.Main* %size_as_ptr to i64

	%1 = alloca %struct.Main*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.Main*
	store %struct.Main* %3, %struct.Main** %1

	%4 = load %struct.Main*, %struct.Main** %1
	call void @Main_init(%struct.Main* %4)

	%5 = load %struct.Main*, %struct.Main** %1
	ret %struct.Main* %5
}

; Initializer
define void @Main_init(%struct.Main*) #0 {
	%2 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %2

	%3 = load %struct.Main*, %struct.Main** %2
	%4 = getelementptr inbounds %struct.Main, %struct.Main* %3, i32 0, i32 0
	call void @IO_init(%struct.IO* %4)

	%5 = load %struct.Main*, %struct.Main** %2
	%6 = getelementptr inbounds %struct.Main, %struct.Main* %5, i32 0, i32 1
	store i32 0, i32* %6

	ret void
}

; Method guessN
define void @Main_guessN(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %2
	
	; Call Method
	%3 = load %struct.Main*, %struct.Main** %2
	%4 = getelementptr inbounds %struct.Main, %struct.Main* %3, i32 0, i32 0
	; Arguments
	; VarValue
	%5 = alloca [5 x i8]
	store [5 x i8] c"n = \00", [5 x i8]* %5
	%6 = bitcast [5 x i8]* %5 to i8*
	
	%7 = call %struct.IO* @IO_print(%struct.IO* %4, i8* %6)
	; Arguments
	; ObjectIdentifier
	%8 = load %struct.Main*, %struct.Main** %2
	%9 = getelementptr inbounds %struct.Main, %struct.Main* %8, i32 0, i32 1
	%10 = load i32, i32* %9

	%11 = call %struct.IO* @IO_printInt32(%struct.IO* %7, i32 %10)
	; Arguments
	; VarValue
	%12 = alloca [12 x i8]
	store [12 x i8] c", guess is \00", [12 x i8]* %12
	%13 = bitcast [12 x i8]* %12 to i8*
	
	%14 = call %struct.IO* @IO_print(%struct.IO* %11, i8* %13)

	; If
	; ObjectIdentifier
	%15 = load %struct.Main*, %struct.Main** %2
	%16 = getelementptr inbounds %struct.Main, %struct.Main* %15, i32 0, i32 1
	%17 = load i32, i32* %16

	; VarValue
	%18 = alloca i32
	store i32 0, i32* %18
	%19 = load i32, i32* %18
	
	; Lower
	%20 = icmp slt i32 %17, %19

	br i1 %20, label %condIf1, label %condElse1	

	condIf1:
		; Call Method
		%21 = load %struct.Main*, %struct.Main** %2
		%22 = getelementptr inbounds %struct.Main, %struct.Main* %21, i32 0, i32 0
		; Arguments
		; VarValue
		%23 = alloca [6 x i8]
		store [6 x i8] c"n < 0\00", [6 x i8]* %23
		%24 = bitcast [6 x i8]* %23 to i8*
		
		%25 = call %struct.IO* @IO_print(%struct.IO* %22, i8* %24)

		br label %condEnd1

	condElse1:
		; If
		; VarValue
		%26 = alloca i32
		store i32 100, i32* %26
		%27 = load i32, i32* %26
		
		; ObjectIdentifier
		%28 = load %struct.Main*, %struct.Main** %2
		%29 = getelementptr inbounds %struct.Main, %struct.Main* %28, i32 0, i32 1
		%30 = load i32, i32* %29

		; Lower
		%31 = icmp slt i32 %27, %30

		br i1 %31, label %condIf2, label %condElse2		

		condIf2:
			; Call Method
			%32 = load %struct.Main*, %struct.Main** %2
			%33 = getelementptr inbounds %struct.Main, %struct.Main* %32, i32 0, i32 0
			; Arguments
			; VarValue
			%34 = alloca [8 x i8]
			store [8 x i8] c"n > 100\00", [8 x i8]* %34
			%35 = bitcast [8 x i8]* %34 to i8*
			
			%36 = call %struct.IO* @IO_print(%struct.IO* %33, i8* %35)

			br label %condEnd2

		condElse2:
			; Call Method
			%37 = load %struct.Main*, %struct.Main** %2
			%38 = getelementptr inbounds %struct.Main, %struct.Main* %37, i32 0, i32 0
			; Arguments
			; VarValue
			%39 = alloca [2 x i8]
			store [2 x i8] c"\0a\00", [2 x i8]* %39
			%40 = bitcast [2 x i8]* %39 to i8*
			
			%41 = call %struct.IO* @IO_print(%struct.IO* %38, i8* %40)

			br label %condEnd2

		condEnd2:
			%42 = phi %struct.IO* [%36, %condIf2], [%41, %condElse2]

		br label %condEnd1

	condEnd1:
		%43 = phi %struct.IO* [%25, %condIf1], [%42, %condElse1]

	ret void
}

; Method main
define i32 @main(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	%3 = call %struct.Main* @Main_new()
	store %struct.Main* %3, %struct.Main** %2
	
	; Call Method
	%4 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %4)

	; VarValue
	%5 = alloca i32
	store i32 0, i32* %5
	%6 = load i32, i32* %5
	
	ret i32 %6
}

