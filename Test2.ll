; ModuleID = 'Test2.vsop'
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
	%struct.IO
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
	ret void
}

; Method useIO
define %struct.IO* @Main_useIO(%struct.Main*, %struct.IO*) #0 {
	; Formals
	%3 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %3
	%4 = alloca %struct.IO*
	store %struct.IO* %1, %struct.IO** %4
	
	; Call Method
	; ObjectIdentifier
	%5 = load %struct.IO*, %struct.IO** %4

	; Arguments
	; VarValue
	%6 = alloca [51 x i8]
	store [51 x i8] c"This argument looks like it is a valid IO object.\0a\00", [51 x i8]* %6
	%7 = bitcast [51 x i8]* %6 to i8*
	
	%8 = call %struct.IO* @IO_print(%struct.IO* %5, i8* %7)

	ret %struct.IO* %8
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
	%6 = load %struct.IO, %struct.IO* %5

	; ObjectIdentifier
	%7 = load %struct.Main*, %struct.Main** %2
	%8 = getelementptr inbounds %struct.Main, %struct.Main* %7, i32 0, i32 0

	; Assign
	store %struct.IO %8, %struct.IO* %5
	
	; ObjectIdentifier
	%9 = load %struct.Main*, %struct.Main** %2
	%10 = getelementptr inbounds %struct.Main, %struct.Main* %9, i32 0, i32 1
	%11 = load %struct.IO, %struct.IO* %10

	; Call Method
	%12 = load %struct.Main*, %struct.Main** %2
	; Arguments
	; ObjectIdentifier
	%13 = load %struct.Main*, %struct.Main** %2
	%14 = getelementptr inbounds %struct.Main, %struct.Main* %13, i32 0, i32 1
	%15 = load %struct.IO, %struct.IO* %14

	%16 = call %struct.IO* @Main_useIO(%struct.Main* %12, %struct.IO* %15)

	; VarValue
	%17 = alloca i32
	store i32 0, i32* %17
	%18 = load i32, i32* %17
	
	ret i32 %18
}

