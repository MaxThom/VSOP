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
%struct.Parent = type {
	%struct.Object
}
%struct.IO = type {
	%struct.Object
}
%struct.Child = type {
	%struct.Parent,
	i8*
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
; PARENT
; 

; Allocation
define %struct.Parent* @Parent.new() #0 {
	%size_as_ptr = getelementptr %struct.Parent, %struct.Parent* null, i32 1
	%size_as_i64 = ptrtoint %struct.Parent* %size_as_ptr to i64

	%1 = alloca %struct.Parent*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.Parent*
	store %struct.Parent* %3, %struct.Parent** %1

	%4 = load %struct.Parent*, %struct.Parent** %1
	call void @Parent.init(%struct.Parent* %4)

	%5 = load %struct.Parent*, %struct.Parent** %1
	ret %struct.Parent* %5
}

; Initializer
define void @Parent.init(%struct.Parent*) #0 {
	%2 = alloca %struct.Parent*
	store %struct.Parent* %0, %struct.Parent** %2

	%3 = load %struct.Parent*, %struct.Parent** %2
	%4 = getelementptr inbounds %struct.Parent, %struct.Parent* %3, i32 0, i32 0
	call void @Object.init(%struct.Object* %4)

	ret void
}

; Method name
define i8* @Parent_name(%struct.Parent*) #0 {
	; Formals
	%2 = alloca %struct.Parent*
	store %struct.Parent* %0, %struct.Parent** %2
	
	; VarValue
	%3 = call noalias i8* @malloc(i64 7) #3
	%4 = bitcast i8* %3 to [7 x i8]*
	store [7 x i8] c"Parent\00", [7 x i8]* %4
	
	ret i8* %3
}

; 
; CHILD
; 

; Allocation
define %struct.Child* @Child.new() #0 {
	%size_as_ptr = getelementptr %struct.Child, %struct.Child* null, i32 1
	%size_as_i64 = ptrtoint %struct.Child* %size_as_ptr to i64

	%1 = alloca %struct.Child*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.Child*
	store %struct.Child* %3, %struct.Child** %1

	%4 = load %struct.Child*, %struct.Child** %1
	call void @Child.init(%struct.Child* %4)

	%5 = load %struct.Child*, %struct.Child** %1
	ret %struct.Child* %5
}

; Initializer
define void @Child.init(%struct.Child*) #0 {
	%2 = alloca %struct.Child*
	store %struct.Child* %0, %struct.Child** %2

	%3 = load %struct.Child*, %struct.Child** %2
	%4 = getelementptr inbounds %struct.Child, %struct.Child* %3, i32 0, i32 0
	call void @Parent.init(%struct.Parent* %4)

	; field #1
	%5 = load %struct.Child*, %struct.Child** %2
	%6 = getelementptr inbounds %struct.Child, %struct.Child* %5, i32 0, i32 1
	; VarValue
	%7 = call noalias i8* @malloc(i64 6) #3
	%8 = bitcast i8* %7 to [6 x i8]*
	store [6 x i8] c"hello\00", [6 x i8]* %8
	
	store i8* %7, i8** %6
	ret void
}

; Method name
define i8* @Child_name(%struct.Child*) #0 {
	; Formals
	%2 = alloca %struct.Child*
	store %struct.Child* %0, %struct.Child** %2
	
	; VarValue
	%3 = call noalias i8* @malloc(i64 6) #3
	%4 = bitcast i8* %3 to [6 x i8]*
	store [6 x i8] c"Child\00", [6 x i8]* %4
	
	ret i8* %3
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
		%9 = call %struct.Parent* @Parent.new()
		store %struct.Parent* %9, %struct.Parent** %8

		br label %condEnd1

	condElse1:
		; New
		%10 = alloca %struct.Child*
		%11 = call %struct.Child* @Child.new()
		store %struct.Child* %11, %struct.Child** %10

		%cast1 = bitcast %struct.Child* %11 to %struct.Parent*
		br label %condEnd1

	condEnd1:
		%12 = phi %struct.Parent* [%9, %condIf1], [%cast1, %condElse1]

	%13 = call i8* @Parent_name(%struct.Parent* %12)

	%14 = call %struct.IO* @IO_print(%struct.IO* %5, i8* %13)

	; Call Method
	%15 = load %struct.Main*, %struct.Main** %2
	%16 = getelementptr inbounds %struct.Main, %struct.Main* %15, i32 0, i32 0
	; Arguments
	; VarValue
	%17 = call noalias i8* @malloc(i64 2) #3
	%18 = bitcast i8* %17 to [2 x i8]*
	store [2 x i8] c"\0a\00", [2 x i8]* %18
	
	%19 = call %struct.IO* @IO_print(%struct.IO* %16, i8* %17)

	; Call Method
	%20 = load %struct.Main*, %struct.Main** %2
	%21 = getelementptr inbounds %struct.Main, %struct.Main* %20, i32 0, i32 0
	; Arguments
	; Call Method
	; If
	; VarValue
	%22 = alloca i1
	store i1 0, i1* %22
	%23 = load i1, i1* %22
	
	br i1 %23, label %condIf2, label %condElse2	

	condIf2:
		; New
		%24 = alloca %struct.Parent*
		%25 = call %struct.Parent* @Parent.new()
		store %struct.Parent* %25, %struct.Parent** %24

		br label %condEnd2

	condElse2:
		; New
		%26 = alloca %struct.Child*
		%27 = call %struct.Child* @Child.new()
		store %struct.Child* %27, %struct.Child** %26

		%cast2 = bitcast %struct.Child* %27 to %struct.Parent*
		br label %condEnd2

	condEnd2:
		%28 = phi %struct.Parent* [%25, %condIf2], [%cast2, %condElse2]

	%29 = call i8* @Parent_name(%struct.Parent* %28)

	%30 = call %struct.IO* @IO_print(%struct.IO* %21, i8* %29)

	; Call Method
	%31 = load %struct.Main*, %struct.Main** %2
	%32 = getelementptr inbounds %struct.Main, %struct.Main* %31, i32 0, i32 0
	; Arguments
	; VarValue
	%33 = call noalias i8* @malloc(i64 2) #3
	%34 = bitcast i8* %33 to [2 x i8]*
	store [2 x i8] c"\0a\00", [2 x i8]* %34
	
	%35 = call %struct.IO* @IO_print(%struct.IO* %32, i8* %33)

	; VarValue
	%36 = alloca i32
	store i32 0, i32* %36
	%37 = load i32, i32* %36
	
	ret i32 %37
}

