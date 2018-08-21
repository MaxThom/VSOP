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
	
	; If
	; VarValue
	%4 = alloca i1
	store i1 0, i1* %4
	%5 = load i1, i1* %4
	
	br i1 %5, label %condIf1, label %condElse1	

	condIf1:
		; VarValue
		%6 = alloca i32
		store i32 0, i32* %6
		%7 = load i32, i32* %6
		
		br label %condEnd1

	condElse1:
		; If
		; VarValue
		%8 = alloca i1
		store i1 0, i1* %8
		%9 = load i1, i1* %8
		
		br i1 %9, label %condIf2, label %condElse2		

		condIf2:
			; Call Method
			%10 = load %struct.Main*, %struct.Main** %2
			%11 = getelementptr inbounds %struct.Main, %struct.Main* %10, i32 0, i32 0
			; Arguments
			; VarValue
			%12 = alloca i32
			store i32 1, i32* %12
			%13 = load i32, i32* %12
			
			%14 = call %struct.IO* @IO_printlnInt32(%struct.IO* %11, i32 %13)

			; VarValue
			%15 = alloca i32
			store i32 0, i32* %15
			%16 = load i32, i32* %15
			
			br label %condEnd2

		condElse2:
			; If
			; VarValue
			%17 = alloca i1
			store i1 1, i1* %17
			%18 = load i1, i1* %17
			
			br i1 %18, label %condIf3, label %condEnd3			

			condIf3:
				; Call Method
				%19 = load %struct.Main*, %struct.Main** %2
				%20 = getelementptr inbounds %struct.Main, %struct.Main* %19, i32 0, i32 0
				; Arguments
				; VarValue
				%21 = alloca i32
				store i32 11, i32* %21
				%22 = load i32, i32* %21
				
				%23 = call %struct.IO* @IO_printlnInt32(%struct.IO* %20, i32 %22)

				; VarValue
				%24 = alloca i32
				store i32 0, i32* %24
				%25 = load i32, i32* %24
				
				br label %condEnd3

			condEnd3:
			; Call Method
			%26 = load %struct.Main*, %struct.Main** %2
			%27 = getelementptr inbounds %struct.Main, %struct.Main* %26, i32 0, i32 0
			; Arguments
			; VarValue
			%28 = alloca i32
			store i32 0, i32* %28
			%29 = load i32, i32* %28
			
			%30 = call %struct.IO* @IO_printlnInt32(%struct.IO* %27, i32 %29)

			; VarValue
			%31 = alloca i32
			store i32 0, i32* %31
			%32 = load i32, i32* %31
			
			br label %condEnd2

		condEnd2:
			%33 = phi i32 [%16, %condIf2], [%32, %condEnd3]

		br label %condEnd1

	condEnd1:
		%34 = phi i32 [%7, %condIf1], [%33, %condEnd2]

	; VarValue
	%35 = alloca i32
	store i32 0, i32* %35
	%36 = load i32, i32* %35
	
	ret i32 %36
}

