; ModuleID = 'Test1.vsop'
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
%struct.A = type {
	%struct.IO,
	%struct.B,
	%struct.B
}
%struct.B = type {
	%struct.IO
}
%struct.IO = type {
	%struct.Object
}
%struct.Main = type {
	%struct.IO,
	%struct.A
}

; 
; B
; 

; Allocation
define %struct.B* @B_new() #0 {
	%size_as_ptr = getelementptr %struct.B, %struct.B* null, i32 1
	%size_as_i64 = ptrtoint %struct.B* %size_as_ptr to i64

	%1 = alloca %struct.B*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.B*
	store %struct.B* %3, %struct.B** %1

	%4 = load %struct.B*, %struct.B** %1
	call void @B_init(%struct.B* %4)

	%5 = load %struct.B*, %struct.B** %1
	ret %struct.B* %5
}

; Initializer
define void @B_init(%struct.B*) #0 {
	%2 = alloca %struct.B*
	store %struct.B* %0, %struct.B** %2

	%3 = load %struct.B*, %struct.B** %2
	%4 = getelementptr inbounds %struct.B, %struct.B* %3, i32 0, i32 0
	call void @IO_init(%struct.IO* %4)

	ret void
}

; Method test
define void @B_test(%struct.B*) #0 {
	; Formals
	%2 = alloca %struct.B*
	store %struct.B* %0, %struct.B** %2
	
	; Call Method
	%3 = load %struct.B*, %struct.B** %2
	%4 = getelementptr inbounds %struct.B, %struct.B* %3, i32 0, i32 0
	; Arguments
	; VarValue
	%5 = alloca [2 x i8]
	store [2 x i8] c"B\00", [2 x i8]* %5
	%6 = bitcast [2 x i8]* %5 to i8*
	
	%7 = call %struct.IO* @IO_println(%struct.IO* %4, i8* %6)

	ret void
}

; 
; A
; 

; Allocation
define %struct.A* @A_new() #0 {
	%size_as_ptr = getelementptr %struct.A, %struct.A* null, i32 1
	%size_as_i64 = ptrtoint %struct.A* %size_as_ptr to i64

	%1 = alloca %struct.A*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.A*
	store %struct.A* %3, %struct.A** %1

	%4 = load %struct.A*, %struct.A** %1
	call void @A_init(%struct.A* %4)

	%5 = load %struct.A*, %struct.A** %1
	ret %struct.A* %5
}

; Initializer
define void @A_init(%struct.A*) #0 {
	%2 = alloca %struct.A*
	store %struct.A* %0, %struct.A** %2

	%3 = load %struct.A*, %struct.A** %2
	%4 = getelementptr inbounds %struct.A, %struct.A* %3, i32 0, i32 0
	call void @IO_init(%struct.IO* %4)

	%5 = load %struct.A*, %struct.A** %2
	%6 = getelementptr inbounds %struct.A, %struct.A* %5, i32 0, i32 1
	%7 = load %struct.A*, %struct.A** %2
	%8 = getelementptr inbounds %struct.A, %struct.A* %7, i32 0, i32 2
	ret void
}

; Method test
define void @A_test(%struct.A*) #0 {
	; Formals
	%2 = alloca %struct.A*
	store %struct.A* %0, %struct.A** %2
	
	; Call Method
	%3 = load %struct.A*, %struct.A** %2
	%4 = getelementptr inbounds %struct.A, %struct.A* %3, i32 0, i32 0
	; Arguments
	; VarValue
	%5 = alloca [2 x i8]
	store [2 x i8] c"A\00", [2 x i8]* %5
	%6 = bitcast [2 x i8]* %5 to i8*
	
	%7 = call %struct.IO* @IO_println(%struct.IO* %4, i8* %6)

	ret void
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
	ret void
}

; Method main
define i32 @main(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	%3 = call %struct.Main* @Main_new()
	store %struct.Main* %3, %struct.Main** %2
	
	; Call Method
	; ObjectIdentifier
	%4 = load %struct.Main*, %struct.Main** %2
	%5 = getelementptr inbounds %struct.Main, %struct.Main* %4, i32 0, i32 1

	%6 = getelementptr inbounds %struct.A, %struct.A* %5, i32 0, i32 2
	call void @B_test(%struct.B* %6)

	; Call Method
	; ObjectIdentifier
	%7 = load %struct.Main*, %struct.Main** %2
	%8 = getelementptr inbounds %struct.Main, %struct.Main* %7, i32 0, i32 1

	call void @A_test(%struct.A* %8)

	; Call Method
	; New
	%9 = alloca %struct.B*
	%10 = call %struct.B* @B_new()
	store %struct.B* %10, %struct.B** %9

	call void @B_test(%struct.B* %10)

	; Call Method
	; New
	%11 = alloca %struct.A*
	%12 = call %struct.A* @A_new()
	store %struct.A* %12, %struct.A** %11

	call void @A_test(%struct.A* %12)

	; Call Method
	%13 = load %struct.Main*, %struct.Main** %2
	%14 = getelementptr inbounds %struct.Main, %struct.Main* %13, i32 0, i32 0
	; Arguments
	; VarValue
	%15 = alloca [7 x i8]
	store [7 x i8] c"tamere\00", [7 x i8]* %15
	%16 = bitcast [7 x i8]* %15 to i8*
	
	%17 = call %struct.IO* @IO_println(%struct.IO* %14, i8* %16)

	; VarValue
	%18 = alloca i32
	store i32 0, i32* %18
	%19 = load i32, i32* %18
	
	ret i32 %19
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
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printBool, i32 0, i32 0), i1 %1)
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
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnBool, i32 0, i32 0), i1 %1)
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


