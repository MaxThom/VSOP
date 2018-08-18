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
	%struct.Object,
	i32
}
%struct.IO = type {
	%struct.Object
}
%struct.Child = type {
	%struct.Parent,
	i32
}
%struct.Main = type {
	%struct.IO,
	i32,
	i8*
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

	%3 = load %struct.Parent*, %struct.Parent** %2
	%4 = getelementptr inbounds %struct.Parent, %struct.Parent* %3, i32 0, i32 1
	store i32 0, i32* %4

	ret void
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

	%5 = load %struct.Child*, %struct.Child** %2
	%6 = getelementptr inbounds %struct.Child, %struct.Child* %5, i32 0, i32 1
	store i32 0, i32* %6

	ret void
}

; Method test
define i32 @test(%struct.Child*) #0 {
	; Formals
	%2 = alloca %struct.Child*
	store %struct.Child* %0, %struct.Child** %2
	
	; VarValue
	%3 = alloca i32
	store i32 0, i32* %3
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

	%5 = load %struct.Main*, %struct.Main** %2
	%6 = getelementptr inbounds %struct.Main, %struct.Main* %5, i32 0, i32 1
	; VarValue
	%7 = alloca i32
	store i32 3, i32* %7
	%8 = load i32, i32* %7
	
	store i32 %8, i32* %6

	%9 = load %struct.Main*, %struct.Main** %2
	%10 = getelementptr inbounds %struct.Main, %struct.Main* %9, i32 0, i32 2
	store i8* getelementptr inbounds ([1 x i8], [1 x i8]* @.str.empty, i32 0, i32 0), i8** %10

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
	%5 = getelementptr inbounds %struct.Main, %struct.Main* %4, i32 0, i32 2
	%6 = load i8*, i8** %5

	; VarValue
	%7 = alloca [5 x i8]
	store [5 x i8] c"test\00", [5 x i8]* %7
	%8 = bitcast [5 x i8]* %7 to i8*
	
	; Assign
	store i8* %8, i8** %5
	
	; Call Method
	%9 = load %struct.Main*, %struct.Main** %2
	%10 = getelementptr inbounds %struct.Main, %struct.Main* %9, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%11 = load %struct.Main*, %struct.Main** %2
	%12 = getelementptr inbounds %struct.Main, %struct.Main* %11, i32 0, i32 1
	%13 = load i32, i32* %12

	%14 = call %struct.IO* @printlnInt32(%struct.IO* %10, i32 %13)

	; Call Method
	%15 = load %struct.Main*, %struct.Main** %2
	%16 = getelementptr inbounds %struct.Main, %struct.Main* %15, i32 0, i32 0
	; Arguments
	; VarValue
	%17 = alloca [14 x i8]
	store [14 x i8] c"Hello World !\00", [14 x i8]* %17
	%18 = bitcast [14 x i8]* %17 to i8*
	
	%19 = call %struct.IO* @println(%struct.IO* %16, i8* %18)

	; Call Method
	%20 = load %struct.Main*, %struct.Main** %2
	%21 = getelementptr inbounds %struct.Main, %struct.Main* %20, i32 0, i32 0
	; Arguments
	; VarValue
	%22 = alloca i1
	store i1 1, i1* %22
	%23 = load i1, i1* %22
	
	%24 = call %struct.IO* @printlnBool(%struct.IO* %21, i1 %23)

	; Call Method
	%25 = load %struct.Main*, %struct.Main** %2
	%26 = getelementptr inbounds %struct.Main, %struct.Main* %25, i32 0, i32 0
	; Arguments
	; VarValue
	%27 = alloca i32
	store i32 3, i32* %27
	%28 = load i32, i32* %27
	
	; VarValue
	%29 = alloca i32
	store i32 4, i32* %29
	%30 = load i32, i32* %29
	
	; Addition
	%31 = add nsw i32 %28, %30
	%32 = alloca i32
	store i32 %31, i32* %32
	%33 = load i32, i32* %32

	%34 = call %struct.IO* @printlnInt32(%struct.IO* %26, i32 %33)

	; Call Method
	%35 = load %struct.Main*, %struct.Main** %2
	%36 = getelementptr inbounds %struct.Main, %struct.Main* %35, i32 0, i32 0
	; Arguments
	; VarValue
	%37 = alloca i32
	store i32 3, i32* %37
	%38 = load i32, i32* %37
	
	; VarValue
	%39 = alloca i32
	store i32 4, i32* %39
	%40 = load i32, i32* %39
	
	; Addition
	%41 = add nsw i32 %38, %40
	%42 = alloca i32
	store i32 %41, i32* %42
	%43 = load i32, i32* %42

	; VarValue
	%44 = alloca i32
	store i32 7, i32* %44
	%45 = load i32, i32* %44
	
	; Equal
	%46 = icmp eq i32 %43, %45

	%47 = call %struct.IO* @printlnBool(%struct.IO* %36, i1 %46)

	; ObjectIdentifier
	%48 = load %struct.Main*, %struct.Main** %2
	%49 = getelementptr inbounds %struct.Main, %struct.Main* %48, i32 0, i32 1
	%50 = load i32, i32* %49

	; Call Method
	%51 = load %struct.Main*, %struct.Main** %2
	%52 = getelementptr inbounds %struct.Main, %struct.Main* %51, i32 0, i32 0
	%53 = call i32 @inputInt32(%struct.IO* %52)

	; Assign
	store i32 %53, i32* %49
	
	; Call Method
	%54 = load %struct.Main*, %struct.Main** %2
	%55 = getelementptr inbounds %struct.Main, %struct.Main* %54, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%56 = load %struct.Main*, %struct.Main** %2
	%57 = getelementptr inbounds %struct.Main, %struct.Main* %56, i32 0, i32 1
	%58 = load i32, i32* %57

	%59 = call %struct.IO* @printlnInt32(%struct.IO* %55, i32 %58)

	; Call Method
	%60 = load %struct.Main*, %struct.Main** %2
	; Arguments
	; VarValue
	%61 = alloca [1 x i8]
	store [1 x i8] c"\00", [1 x i8]* %61
	%62 = bitcast [1 x i8]* %61 to i8*
	
	; VarValue
	%63 = alloca i32
	store i32 0, i32* %63
	%64 = load i32, i32* %63
	
	; VarValue
	%65 = alloca i1
	store i1 0, i1* %65
	%66 = load i1, i1* %65
	
	%67 = call i32 @main2(%struct.Main* %60, i8* %62, i32 %64, i1 %66)

	; VarValue
	%68 = alloca i32
	store i32 0, i32* %68
	%69 = load i32, i32* %68
	
	ret i32 %69
}

; Method main2
define i32 @main2(%struct.Main*, i8*, i32, i1) #0 {
	; Formals
	%5 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %5
	%6 = alloca i8*
	store i8* %1, i8** %6
	%7 = alloca i32
	store i32 %2, i32* %7
	%8 = alloca i1
	store i1 %3, i1* %8
	
	; Call Method
	%9 = load %struct.Main*, %struct.Main** %5
	%10 = getelementptr inbounds %struct.Main, %struct.Main* %9, i32 0, i32 0
	; Arguments
	; VarValue
	%11 = alloca [25 x i8]
	store [25 x i8] c"Please enter a string : \00", [25 x i8]* %11
	%12 = bitcast [25 x i8]* %11 to i8*
	
	%13 = call %struct.IO* @println(%struct.IO* %10, i8* %12)

	; ObjectIdentifier
	%14 = load i8*, i8** %6

	; Call Method
	%15 = load %struct.Main*, %struct.Main** %5
	%16 = getelementptr inbounds %struct.Main, %struct.Main* %15, i32 0, i32 0
	%17 = call i8* @inputLine(%struct.IO* %16)

	; Assign
	store i8* %17, i8** %6
	
	; Call Method
	%18 = load %struct.Main*, %struct.Main** %5
	%19 = getelementptr inbounds %struct.Main, %struct.Main* %18, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%20 = load i8*, i8** %6

	%21 = call %struct.IO* @println(%struct.IO* %19, i8* %20)

	; Call Method
	%22 = load %struct.Main*, %struct.Main** %5
	%23 = getelementptr inbounds %struct.Main, %struct.Main* %22, i32 0, i32 0
	; Arguments
	; VarValue
	%24 = alloca [22 x i8]
	store [22 x i8] c"Please enter a int : \00", [22 x i8]* %24
	%25 = bitcast [22 x i8]* %24 to i8*
	
	%26 = call %struct.IO* @println(%struct.IO* %23, i8* %25)

	; ObjectIdentifier
	%27 = load i32, i32* %7

	; Call Method
	%28 = load %struct.Main*, %struct.Main** %5
	%29 = getelementptr inbounds %struct.Main, %struct.Main* %28, i32 0, i32 0
	%30 = call i32 @inputInt32(%struct.IO* %29)

	; Assign
	store i32 %30, i32* %7
	
	; Call Method
	%31 = load %struct.Main*, %struct.Main** %5
	%32 = getelementptr inbounds %struct.Main, %struct.Main* %31, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%33 = load i32, i32* %7

	%34 = call %struct.IO* @printlnInt32(%struct.IO* %32, i32 %33)

	; Call Method
	%35 = load %struct.Main*, %struct.Main** %5
	%36 = getelementptr inbounds %struct.Main, %struct.Main* %35, i32 0, i32 0
	; Arguments
	; VarValue
	%37 = alloca [23 x i8]
	store [23 x i8] c"Please enter a bool : \00", [23 x i8]* %37
	%38 = bitcast [23 x i8]* %37 to i8*
	
	%39 = call %struct.IO* @println(%struct.IO* %36, i8* %38)

	; ObjectIdentifier
	%40 = load i1, i1* %8

	; Call Method
	%41 = load %struct.Main*, %struct.Main** %5
	%42 = getelementptr inbounds %struct.Main, %struct.Main* %41, i32 0, i32 0
	%43 = call i1 @inputBool(%struct.IO* %42)

	; Assign
	store i1 %43, i1* %8
	
	; Call Method
	%44 = load %struct.Main*, %struct.Main** %5
	%45 = getelementptr inbounds %struct.Main, %struct.Main* %44, i32 0, i32 0
	; Arguments
	; ObjectIdentifier
	%46 = load i1, i1* %8

	%47 = call %struct.IO* @printlnBool(%struct.IO* %45, i1 %46)

	; VarValue
	%48 = alloca i32
	store i32 0, i32* %48
	%49 = load i32, i32* %48
	
	ret i32 %49
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

define %struct.IO* @printInt32(%struct.IO*, i32) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printInt, i32 0, i32 0), i32 %1)
	ret %struct.IO* %0
}
define %struct.IO* @printBool(%struct.IO*, i1) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printBool, i32 0, i32 0), i1 %1)
	ret %struct.IO* %0
}
define %struct.IO* @print(%struct.IO*, i8*) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printStr, i32 0, i32 0), i8* %1)
	ret %struct.IO* %0
}
define %struct.IO* @printlnInt32(%struct.IO*, i32) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnInt, i32 0, i32 0), i32 %1)
	ret %struct.IO* %0
}
define %struct.IO* @printlnBool(%struct.IO*, i1) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnBool, i32 0, i32 0), i1 %1)
	ret %struct.IO* %0
}
define %struct.IO* @println(%struct.IO*, i8*) {
	%3 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnStr, i32 0, i32 0), i8* %1)
	ret %struct.IO* %0
}
define i32 @inputInt32(%struct.IO*) {
    %2 = alloca i32, align 4
    %3 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputInt, i32 0, i32 0), i32* %2)
    %4 = load i32, i32* %2

    %5 = icmp eq i32 %3, 0
    br i1 %5, label %exit, label %end

    exit:
        %msg = alloca [40 x i8]
        store [40 x i8] c"Error : invalid input. Expecting int32.\00", [40 x i8]* %msg
        %loadedMsg = bitcast [40 x i8]* %msg to i8*
        call %struct.IO* @println(%struct.IO* %0, i8* %loadedMsg)
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
        call %struct.IO* @println(%struct.IO* %0, i8* %loadedMsg)
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


