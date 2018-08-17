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
%struct.Main = type {
	%struct.Object,
	i8*
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
	%4 = getelementptr inbounds %struct.Main, %struct.Main* %3, i32 0, i32 1
	; VarValue
	%5 = alloca [6 x i8]
	store [6 x i8] c"test2\00", [6 x i8]* %5
	%6 = bitcast [6 x i8]* %5 to i8*
	
	store i8* %6, i8** %4

	ret void
}

; Method main
define i32 @main(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	%3 = call %struct.Main* @Main_new()
	store %struct.Main* %3, %struct.Main** %2
	
	; New
	%4 = alloca %struct.Main*
	%5 = call %struct.Main* @Main_new()
	store %struct.Main* %5, %struct.Main** %4

	; VarValue
	%6 = alloca i32
	store i32 0, i32* %6
	%7 = load i32, i32* %6
	
	ret i32 %7
}

; Method main2
define i32 @main2(%struct.Main*, i32) #0 {
	; Formals
	%3 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %3
	%4 = alloca i32
	store i32 %1, i32* %4
	
	; VarValue
	%5 = alloca i32
	store i32 1, i32* %5
	%6 = load i32, i32* %5
	
	; Assign
	store i32 %6, i32* %4
	
	; If
	; ObjectIdentifier
	%7 = load %struct.Main*, %struct.Main** %3
	%8 = getelementptr inbounds %struct.Main, %struct.Main* %7, i32 0, i32 1
	%9 = load i8*, i8** %8
	
	; ObjectIdentifier
	%10 = load %struct.Main*, %struct.Main** %3
	%11 = getelementptr inbounds %struct.Main, %struct.Main* %10, i32 0, i32 1
	%12 = load i8*, i8** %11
	
	; Equal
	%13 = call i32 @strcmp(i8* %9, i8* %12) #2
	%14 = icmp eq i32 %13, 0

	; ObjectIdentifier
	%15 = load i32, i32* %4
	
	; VarValue
	%16 = alloca i32
	store i32 3, i32* %16
	%17 = load i32, i32* %16
	
	; Lower or Equal
	%18 = icmp sle i32 %15, %17

	; And
	%19 = and i1 %14, %18

	; VarValue
	%20 = alloca i1
	store i1 1, i1* %20
	%21 = load i1, i1* %20
	
	; And
	%22 = and i1 %19, %21

	br i1 %22, label %condIf1, label %condElse1	

	condIf1:
		; While
		br label %whileCond2
		whileCond2:
			; ObjectIdentifier
			%23 = load i32, i32* %4
			
			; VarValue
			%24 = alloca i32
			store i32 10, i32* %24
			%25 = load i32, i32* %24
			
			; Lower or Equal
			%26 = icmp sle i32 %23, %25

			br i1 %26, label %while2, label %whileEnd2

		while2:
			; ObjectIdentifier
			%27 = load i32, i32* %4
			
			; VarValue
			%28 = alloca i32
			store i32 1, i32* %28
			%29 = load i32, i32* %28
			
			; Addition
			%30 = add nsw i32 %27, %29
			%31 = alloca i32
			store i32 %30, i32* %31
			%32 = load i32, i32* %31

			; Assign
			store i32 %32, i32* %4
			
			br label %whileCond2

		whileEnd2:
		br label %condEnd1

	condElse1:
		; VarValue
		%33 = alloca i32
		store i32 5, i32* %33
		%34 = load i32, i32* %33
		
		; Assign
		store i32 %34, i32* %4
		
		br label %condEnd1

	condEnd1:
	; ObjectIdentifier
	%35 = load i32, i32* %4
	
	ret i32 %35
}

; 
; IO Class
; 
%struct.IO = type { }

; Allocation
define %struct.IO* @IO_new() #0 {
	%1 = alloca %struct.IO*
	%2 = call noalias i8* @malloc(i64 0) #3
	%3 = bitcast i8* %2 to %struct.IO*
	store %struct.IO* %3, %struct.IO** %1
	%4 = load %struct.IO*, %struct.IO** %1
	ret %struct.IO* %4
}

@IO.printInt = private constant [3 x i8] c"%d\00"
@IO.printStr = private constant [3 x i8] c"%s\00"
@IO.printBool = private constant [3 x i8] c"%d\00"
@IO.printlnInt = private constant [4 x i8] c"%d\0A\00"
@IO.printlnStr = private constant [4 x i8] c"%s\0A\00"
@IO.printlnBool = private constant [4 x i8] c"%d\0A\00"
@IO.inputInt = private constant [3 x i8] c"%d\00"
@IO.inputStr = private constant [3 x i8] c"%s\00"

define %struct.IO* @printInt(%struct.IO*, i32) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printInt, i32 0, i32 0), i32 %1)
	ret %struct.IO* %0
}
define %struct.IO* @printBool(%struct.IO*, i1) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printBool, i32 0, i32 0), i1 %1)
	ret %struct.IO* %0
}
define %struct.IO* @printStr(%struct.IO*, i8*) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printStr, i32 0, i32 0), i8* %1)
	ret %struct.IO* %0
}
define %struct.IO* @printlnInt(%struct.IO*, i32) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnInt, i32 0, i32 0), i32 %1)
	ret %struct.IO* %0
}
define %struct.IO* @printlnBool(%struct.IO*, i1) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnBool, i32 0, i32 0), i1 %1)
	ret %struct.IO* %0
}
define %struct.IO* @printlnStr(%struct.IO*, i8*) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnStr, i32 0, i32 0), i8* %1)
	ret %struct.IO* %0
}
define i32 @inputInt(%struct.IO*) {
    %2 = alloca i32, align 4
    %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputInt, i32 0, i32 0), i32* %2)
    %4 = load i32, i32* %2

    %5 = icmp eq i32 %3, 0
    br i1 %5, label %exit, label %end

    exit:
        %msg = alloca [40 x i8]
        store [40 x i8] c"Error : invalid input. Expecting int32.\00", [40 x i8]* %msg
        %loadedMsg = bitcast [40 x i8]* %msg to i8*
        call %struct.IO* @printlnStr(%struct.IO* %0, i8* %loadedMsg)
        call void @exit(i32 1) #3
        br label %end

    end:
	    ret i32 %4
}
define i1 @inputBool(%struct.IO*) {
    %2 = alloca i32, align 4
    %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputInt, i32 0, i32 0), i32* %2)
    %4 = load i32, i32* %2

    %5 = icmp eq i32 %3, 0
    br i1 %5, label %exit, label %end

    exit:
        %msg = alloca [49 x i8]
        store [49 x i8] c"Error : invalid input. Expecting boolean 1 or 0.\00", [49 x i8]* %msg
        %loadedMsg = bitcast [49 x i8]* %msg to i8*
        call %struct.IO* @printlnStr(%struct.IO* %0, i8* %loadedMsg)
        call void @exit(i32 1) #3
        br label %end

    end:
        %7 = icmp ne i32 %4, 0
	    ret i1 %7
}
define i8* @inputLine(%struct.IO*) {
    %2 = alloca i8*
    %3 = load i8*, i8** %2
    
    %4 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputStr, i32 0, i32 0), i8* %3)
    %5 = load i8*, i8** %2

    ret i8* %5
}


