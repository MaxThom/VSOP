; ModuleID = 'Test1.vsop'
; 
; DECLARATION
; 
declare noalias i8* @malloc(i64) #1
declare i32 @printf(i8*, ...)
declare double @pow(double, double) #1
@.str.empty = private unnamed_addr constant [1 x i8] zeroinitializer, align 1

; 
; STRUCTURES
; 
%struct.Object = type { }
%struct.Main = type {
	%struct.Object
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

	ret void
}

; Method main
define i32 @main(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	%3 = call %struct.Main* @Main_new()
	store %struct.Main* %3, %struct.Main** %2
	
	; VarValue
	%4 = alloca i32
	store i32 3, i32* %4
	%5 = load i32, i32* %4
	
	; VarValue
	%6 = alloca i32
	store i32 4, i32* %6
	%7 = load i32, i32* %6
	
	; Subtraction
	%8 = sub nsw i32 %5, %7
	%9 = alloca i32
	store i32 %8, i32* %9
	%10 = load i32, i32* %9

	; VarValue
	%11 = alloca i32
	store i32 4, i32* %11
	%12 = load i32, i32* %11
	
	; VarValue
	%13 = alloca i32
	store i32 1, i32* %13
	%14 = load i32, i32* %13
	
	; Subtraction
	%15 = sub nsw i32 %12, %14
	%16 = alloca i32
	store i32 %15, i32* %16
	%17 = load i32, i32* %16

	; VarValue
	%18 = alloca i32
	store i32 2, i32* %18
	%19 = load i32, i32* %18
	
	; VarValue
	%20 = alloca i32
	store i32 5, i32* %20
	%21 = load i32, i32* %20
	
	; Addition
	%22 = add nsw i32 %19, %21
	%23 = alloca i32
	store i32 %22, i32* %23
	%24 = load i32, i32* %23

	; VarValue
	%25 = alloca i32
	store i32 3, i32* %25
	%26 = load i32, i32* %25
	
	; VarValue
	%27 = alloca i32
	store i32 3, i32* %27
	%28 = load i32, i32* %27
	
	; Division
	%29 = sdiv i32 %26, %28
	%30 = alloca i32
	store i32 %29, i32* %30
	%31 = load i32, i32* %30

	; VarValue
	%32 = alloca i32
	store i32 2, i32* %32
	%33 = load i32, i32* %32
	
	; VarValue
	%34 = alloca i32
	store i32 6, i32* %34
	%35 = load i32, i32* %34
	
	; Multiplication
	%36 = mul nsw i32 %33, %35
	%37 = alloca i32
	store i32 %36, i32* %37
	%38 = load i32, i32* %37

	; VarValue
	%39 = alloca i32
	store i32 0, i32* %39
	%40 = load i32, i32* %39
	
	ret i32 %40
}

; 
; IO Class
; 
@IO.printInt = private constant [3 x i8] c"%d\00"
@IO.printStr = private constant [3 x i8] c"%s\00"
@IO.printBool = private constant [3 x i8] c"%d\00"
@IO.printlnInt = private constant [4 x i8] c"%d\0A\00"
@IO.printlnStr = private constant [4 x i8] c"%s\0A\00"
@IO.printlnBool = private constant [4 x i8] c"%d\0A\00"

define void @printInt(i32) {
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printInt, i32 0, i32 0), i32 %0)
	ret void
}
define void @printBool(i1) {
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printBool, i32 0, i32 0), i1 %0)
	ret void
}
define void @printStr(i8*) {
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.printStr, i32 0, i32 0), i8* %0)
	ret void
}
define void @printlnInt(i32) {
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnInt, i32 0, i32 0), i32 %0)
	ret void
}
define void @printlnBool(i1) {
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnBool, i32 0, i32 0), i1 %0)
	ret void
}
define void @printlnStr(i8*) {
	%2 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @IO.printlnStr, i32 0, i32 0), i8* %0)
	ret void
}
