; ModuleID = 'Test1.vsop'
; 
; DECLARATION
; 
declare noalias i8* @malloc(i64) #1
declare i32 @printf(i8*, ...)
declare double @pow(double, double) #1
declare i32 @strcmp(i8*, i8*) #1
declare i32 @__isoc99_scanf(i8*, ...) #1
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
	%struct.IO,
	%struct.IO*,
	%struct.IO*,
	%struct.IO*,
	i32,
	i8*,
	i1
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

	; field #1
	%5 = load %struct.Main*, %struct.Main** %2
	%6 = getelementptr inbounds %struct.Main, %struct.Main* %5, i32 0, i32 1
	; New
	%7 = alloca %struct.IO*
	%8 = call %struct.IO* @IO_new()
	store %struct.IO* %8, %struct.IO** %7

	store %struct.IO* %8, %struct.IO** %6
	; field #2
	%9 = load %struct.Main*, %struct.Main** %2
	%10 = getelementptr inbounds %struct.Main, %struct.Main* %9, i32 0, i32 2
		; New
		%11 = alloca %struct.IO*
		%12 = call %struct.IO* @IO_new()
		store %struct.IO* %12, %struct.IO** %11

	store %struct.IO* %12, %struct.IO** %10
	; field #3
	%13 = load %struct.Main*, %struct.Main** %2
	%14 = getelementptr inbounds %struct.Main, %struct.Main* %13, i32 0, i32 3
	store %struct.IO* null, %struct.IO** %14

	; field #4
	%15 = load %struct.Main*, %struct.Main** %2
	%16 = getelementptr inbounds %struct.Main, %struct.Main* %15, i32 0, i32 4
	; VarValue
	%17 = alloca i32
	store i32 23, i32* %17
	%18 = load i32, i32* %17
	
	store i32 %18, i32* %16
	; field #5
	%19 = load %struct.Main*, %struct.Main** %2
	%20 = getelementptr inbounds %struct.Main, %struct.Main* %19, i32 0, i32 5
	; VarValue
	%21 = call noalias i8* @malloc(i64 7) #3
	%22 = bitcast i8* %21 to [7 x i8]*
	store [7 x i8] c"string\00", [7 x i8]* %22
	
	store i8* %21, i8** %20
	; field #6
	%23 = load %struct.Main*, %struct.Main** %2
	%24 = getelementptr inbounds %struct.Main, %struct.Main* %23, i32 0, i32 6
	; VarValue
	%25 = alloca i1
	store i1 1, i1* %25
	%26 = load i1, i1* %25
	
	store i1 %26, i1* %24
	ret void
}

; Method main
define i32 @main(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	%3 = call %struct.Main* @Main_new()
	store %struct.Main* %3, %struct.Main** %2
	
	; ObjectIdentifier
	%4 = load %struct.Main*, %struct.Main** %2
	%5 = getelementptr inbounds %struct.Main, %struct.Main* %4, i32 0, i32 1
	%6 = load %struct.IO*, %struct.IO** %5

	; IsNull
	%7 = icmp eq %struct.IO* %6, null

	; Call Method
	%8 = load %struct.Main*, %struct.Main** %2
	%9 = getelementptr inbounds %struct.Main, %struct.Main* %8, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%10 = load %struct.Main*, %struct.Main** %2
	%11 = getelementptr inbounds %struct.Main, %struct.Main* %10, i32 0, i32 1
	%12 = load %struct.IO*, %struct.IO** %11

	; IsNull
	%13 = icmp eq %struct.IO* %12, null

	%14 = call %struct.IO* @IO_printlnBool(%struct.IO* %9, i1 %13)

	; Call Method
	%15 = load %struct.Main*, %struct.Main** %2
	%16 = getelementptr inbounds %struct.Main, %struct.Main* %15, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%17 = load %struct.Main*, %struct.Main** %2
	%18 = getelementptr inbounds %struct.Main, %struct.Main* %17, i32 0, i32 2
	%19 = load %struct.IO*, %struct.IO** %18

	; IsNull
	%20 = icmp eq %struct.IO* %19, null

	%21 = call %struct.IO* @IO_printlnBool(%struct.IO* %16, i1 %20)

	; Call Method
	%22 = load %struct.Main*, %struct.Main** %2
	%23 = getelementptr inbounds %struct.Main, %struct.Main* %22, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%24 = load %struct.Main*, %struct.Main** %2
	%25 = getelementptr inbounds %struct.Main, %struct.Main* %24, i32 0, i32 3
	%26 = load %struct.IO*, %struct.IO** %25

	; IsNull
	%27 = icmp eq %struct.IO* %26, null

	%28 = call %struct.IO* @IO_printlnBool(%struct.IO* %23, i1 %27)

	; Call Method
	%29 = load %struct.Main*, %struct.Main** %2
	%30 = getelementptr inbounds %struct.Main, %struct.Main* %29, i32 0, i32 0
	; Arguments
	; New
	%31 = alloca %struct.IO*
	%32 = call %struct.IO* @IO_new()
	store %struct.IO* %32, %struct.IO** %31

	; IsNull
	%33 = icmp eq %struct.IO* %32, null

	%34 = call %struct.IO* @IO_printlnBool(%struct.IO* %30, i1 %33)

	; Call Method
	%35 = load %struct.Main*, %struct.Main** %2
	%36 = getelementptr inbounds %struct.Main, %struct.Main* %35, i32 0, i32 0
	; Arguments
	; New
	%37 = alloca %struct.IO*
	%38 = call %struct.IO* @IO_new()
	store %struct.IO* %38, %struct.IO** %37

	; IsNull
	%39 = icmp eq %struct.IO* %38, null

	; Not
	%40 = alloca i1
	br i1 %39, label %notTrue1 , label %notFalse1
	notTrue1:
		store i1 0, i1* %40
		br label %notEnd1
	notFalse1:
		store i1 1, i1* %40
		br label %notEnd1
	notEnd1:
		%41 = load i1, i1* %40

	%42 = call %struct.IO* @IO_printlnBool(%struct.IO* %36, i1 %41)

	; Call Method
	%43 = load %struct.Main*, %struct.Main** %2
	%44 = getelementptr inbounds %struct.Main, %struct.Main* %43, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%45 = load %struct.Main*, %struct.Main** %2
	%46 = getelementptr inbounds %struct.Main, %struct.Main* %45, i32 0, i32 5
	%47 = load i8*, i8** %46

	%48 = call %struct.IO* @IO_println(%struct.IO* %44, i8* %47)

	; Call Method
	%49 = load %struct.Main*, %struct.Main** %2
	%50 = getelementptr inbounds %struct.Main, %struct.Main* %49, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%51 = load %struct.Main*, %struct.Main** %2
	%52 = getelementptr inbounds %struct.Main, %struct.Main* %51, i32 0, i32 4
	%53 = load i32, i32* %52

	%54 = call %struct.IO* @IO_printlnInt32(%struct.IO* %50, i32 %53)

	; Call Method
	%55 = load %struct.Main*, %struct.Main** %2
	%56 = getelementptr inbounds %struct.Main, %struct.Main* %55, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%57 = load %struct.Main*, %struct.Main** %2
	%58 = getelementptr inbounds %struct.Main, %struct.Main* %57, i32 0, i32 6
	%59 = load i1, i1* %58

	%60 = call %struct.IO* @IO_printlnBool(%struct.IO* %56, i1 %59)

	; VarValue
	%61 = alloca i32
	store i32 0, i32* %61
	%62 = load i32, i32* %61
	
	ret i32 %62
}

; Method main2
define i32 @Main_main2(%struct.Main*, %struct.IO*, i32, i8*, i8*) #0 {
	; Formals
	%6 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %6
	%7 = alloca %struct.IO*
	store %struct.IO* %1, %struct.IO** %7
	%8 = alloca i32
	store i32 %2, i32* %8
	%9 = alloca i8*
	store i8* %3, i8** %9
	%10 = alloca i8*
	store i8* %4, i8** %10
	
	; Call Method
	%11 = load %struct.Main*, %struct.Main** %6
	%12 = getelementptr inbounds %struct.Main, %struct.Main* %11, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%13 = load %struct.IO*, %struct.IO** %7

	; IsNull
	%14 = icmp eq %struct.IO* %13, null

	%15 = call %struct.IO* @IO_printlnBool(%struct.IO* %12, i1 %14)

	; ObjectIdentifier
	%16 = load %struct.IO*, %struct.IO** %7

	; New
	%17 = alloca %struct.IO*
	%18 = call %struct.IO* @IO_new()
	store %struct.IO* %18, %struct.IO** %17

	; Assign
	store %struct.IO* %18, %struct.IO** %7
	
	; ObjectIdentifier
	%19 = load %struct.IO*, %struct.IO** %7

	; Call Method
	%20 = load %struct.Main*, %struct.Main** %6
	%21 = getelementptr inbounds %struct.Main, %struct.Main* %20, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%22 = load %struct.IO*, %struct.IO** %7

	; IsNull
	%23 = icmp eq %struct.IO* %22, null

	%24 = call %struct.IO* @IO_printlnBool(%struct.IO* %21, i1 %23)

	; ObjectIdentifier
	%25 = load i32, i32* %8

	; VarValue
	%26 = alloca i32
	store i32 2, i32* %26
	%27 = load i32, i32* %26
	
	; Assign
	store i32 %27, i32* %8
	
	; ObjectIdentifier
	%28 = load i32, i32* %8

	; ObjectIdentifier
	%29 = load i8*, i8** %9

	; VarValue
	%30 = alloca [5 x i8]
	store [5 x i8] c"test\00", [5 x i8]* %30
	%31 = bitcast [5 x i8]* %30 to i8*
	
	; Assign
	store i8* %31, i8** %9
	
	; ObjectIdentifier
	%32 = load i8*, i8** %9

	; ObjectIdentifier
	%33 = load i8*, i8** %10

	; VarValue
	%34 = alloca [5 x i8]
	store [5 x i8] c"test\00", [5 x i8]* %34
	%35 = bitcast [5 x i8]* %34 to i8*
	
	; Assign
	store i8* %35, i8** %10
	
	; ObjectIdentifier
	%36 = load i8*, i8** %10

	; If
	; ObjectIdentifier
	%37 = load i8*, i8** %9

	; ObjectIdentifier
	%38 = load i8*, i8** %10

	; Equal
	%39 = call i32 @strcmp(i8* %37, i8* %38) #2
	%40 = icmp eq i32 %39, 0

	br i1 %40, label %condIf1, label %condEnd1	

	condIf1:
		; Call Method
		%41 = load %struct.Main*, %struct.Main** %6
		%42 = getelementptr inbounds %struct.Main, %struct.Main* %41, i32 0, i32 0
		; Arguments
		; VarValue
		%43 = alloca [5 x i8]
		store [5 x i8] c"true\00", [5 x i8]* %43
		%44 = bitcast [5 x i8]* %43 to i8*
		
		%45 = call %struct.IO* @IO_println(%struct.IO* %42, i8* %44)

		br label %condEnd1

	condEnd1:
	; VarValue
	%46 = alloca i32
	store i32 0, i32* %46
	%47 = load i32, i32* %46
	
	ret i32 %47
}

