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
%struct.Parent = type {
	%struct.Object
}
%struct.IO = type {
	%struct.Object
}
%struct.Child = type {
	%struct.Parent
}
%struct.Main = type {
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
; PARENT
; 

; Allocation
define %struct.Parent* @Parent_new() #0 {
	%size_as_ptr = getelementptr %struct.Parent, %struct.Parent* null, i32 1
	%size_as_i64 = ptrtoint %struct.Parent* %size_as_ptr to i64

	%1 = alloca %struct.Parent*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.Parent*
	store %struct.Parent* %3, %struct.Parent** %1

	%4 = load %struct.Parent*, %struct.Parent** %1
	call void @Parent_init(%struct.Parent* %4)

	%5 = load %struct.Parent*, %struct.Parent** %1
	ret %struct.Parent* %5
}

; Initializer
define void @Parent_init(%struct.Parent*) #0 {
	%2 = alloca %struct.Parent*
	store %struct.Parent* %0, %struct.Parent** %2

	ret void
}

; Method name
define i32 @Parent_name(%struct.Parent*) #0 {
	; Formals
	%2 = alloca %struct.Parent*
	store %struct.Parent* %0, %struct.Parent** %2
	
	; VarValue
	%3 = alloca i32
	store i32 50, i32* %3
	%4 = load i32, i32* %3
	
	ret i32 %4
}

; 
; CHILD
; 

; Allocation
define %struct.Child* @Child_new() #0 {
	%size_as_ptr = getelementptr %struct.Child, %struct.Child* null, i32 1
	%size_as_i64 = ptrtoint %struct.Child* %size_as_ptr to i64

	%1 = alloca %struct.Child*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.Child*
	store %struct.Child* %3, %struct.Child** %1

	%4 = load %struct.Child*, %struct.Child** %1
	call void @Child_init(%struct.Child* %4)

	%5 = load %struct.Child*, %struct.Child** %1
	ret %struct.Child* %5
}

; Initializer
define void @Child_init(%struct.Child*) #0 {
	%2 = alloca %struct.Child*
	store %struct.Child* %0, %struct.Child** %2

	%3 = load %struct.Child*, %struct.Child** %2
	%4 = getelementptr inbounds %struct.Child, %struct.Child* %3, i32 0, i32 0
	call void @Parent_init(%struct.Parent* %4)

	ret void
}

; Method name
define i32 @Child_name(%struct.Child*) #0 {
	; Formals
	%2 = alloca %struct.Child*
	store %struct.Child* %0, %struct.Child** %2
	
	; VarValue
	%3 = alloca i32
	store i32 20, i32* %3
	%4 = load i32, i32* %3
	
	ret i32 %4
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
	%5 = getelementptr inbounds %struct.Main, %struct.Main* %4, i32 0, i32 0
	; Arguments
	; Call Method
	; If
	; VarValue
	%6 = alloca i1
	store i1 1, i1* %6
	%7 = load i1, i1* %6
	
	br i1 %7, label %condIf1, label %condElse1	

	condIf1:
		; New
		%8 = alloca %struct.Parent*
		%9 = call %struct.Parent* @Parent_new()
		store %struct.Parent* %9, %struct.Parent** %8
		%10 = load %struct.Parent, %struct.Parent* %9
		br label %condEnd1

	condElse1:
		; New
		%11 = alloca %struct.Child*
		%12 = call %struct.Child* @Child_new()
		store %struct.Child* %12, %struct.Child** %11
		%13 = load %struct.Child, %struct.Child* %12
		%cast1 = bitcast %struct.Child* %12 to %struct.Parent*
		br label %condEnd1

	condEnd1:
		%14 = phi %struct.Parent* [%9, %condIf1], [%cast1, %condElse1]

	%15 = call i32 @Parent_name(%struct.Parent* %14)

	%16 = call %struct.IO* @IO_printInt32(%struct.IO* %5, i32 %15)

	; Call Method
	%17 = load %struct.Main*, %struct.Main** %2
	%18 = getelementptr inbounds %struct.Main, %struct.Main* %17, i32 0, i32 0
	; Arguments
	; VarValue
	%19 = alloca [2 x i8]
	store [2 x i8] c"\0a\00", [2 x i8]* %19
	%20 = bitcast [2 x i8]* %19 to i8*
	
	%21 = call %struct.IO* @IO_print(%struct.IO* %18, i8* %20)

	; Call Method
	%22 = load %struct.Main*, %struct.Main** %2
	%23 = getelementptr inbounds %struct.Main, %struct.Main* %22, i32 0, i32 0
	; Arguments
	; Call Method
	; If
	; VarValue
	%24 = alloca i1
	store i1 0, i1* %24
	%25 = load i1, i1* %24
	
	br i1 %25, label %condIf2, label %condElse2	

	condIf2:
		; New
		%26 = alloca %struct.Parent*
		%27 = call %struct.Parent* @Parent_new()
		store %struct.Parent* %27, %struct.Parent** %26
		%28 = load %struct.Parent, %struct.Parent* %27
		br label %condEnd2

	condElse2:
		; New
		%29 = alloca %struct.Child*
		%30 = call %struct.Child* @Child_new()
		store %struct.Child* %30, %struct.Child** %29
		%31 = load %struct.Child, %struct.Child* %30
		%cast2 = bitcast %struct.Child* %30 to %struct.Parent*
		br label %condEnd2

	condEnd2:
		%32 = phi %struct.Parent* [%27, %condIf2], [%cast2, %condElse2]

	%33 = call i32 @Parent_name(%struct.Parent* %32)

	%34 = call %struct.IO* @IO_printInt32(%struct.IO* %23, i32 %33)

	; Call Method
	%35 = load %struct.Main*, %struct.Main** %2
	%36 = getelementptr inbounds %struct.Main, %struct.Main* %35, i32 0, i32 0
	; Arguments
	; VarValue
	%37 = alloca [2 x i8]
	store [2 x i8] c"\0a\00", [2 x i8]* %37
	%38 = bitcast [2 x i8]* %37 to i8*
	
	%39 = call %struct.IO* @IO_print(%struct.IO* %36, i8* %38)

	; VarValue
	%40 = alloca i32
	store i32 0, i32* %40
	%41 = load i32, i32* %40
	
	ret i32 %41
}

