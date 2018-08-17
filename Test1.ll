; ModuleID = 'Test1.vsop'
; 
; DECLARATION
; 
declare noalias i8* @malloc(i64) #1
declare i32 @printf(i8*, ...)
declare double @pow(double, double) #1
declare i32 @strcmp(i8*, i8*) #1
@.str.empty = private unnamed_addr constant [1 x i8] zeroinitializer, align 1

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
	
	; ObjectIdentifier
	%4 = load %struct.Main*, %struct.Main** %2
	%5 = getelementptr inbounds %struct.Main, %struct.Main* %4, i32 0, i32 1
	%6 = load i8*, i8** %5
	
	; ObjectIdentifier
	%7 = load %struct.Main*, %struct.Main** %2
	%8 = getelementptr inbounds %struct.Main, %struct.Main* %7, i32 0, i32 1
	%9 = load i8*, i8** %8
	
	%10 = call i32 @strcmp(i8* %6, i8* %9) #2
	; Equal
	%11 = icmp eq i32 %10, 0

	; Not
	%12 = alloca i1
	br i1 %11, label %notTrue1 , label %notFalse2
	notTrue1:
		store i1 0, i1* %12
		br label %notEnd3	notFalse2:
		store i1 1, i1* %12
		br label %notEnd3	notEnd3:
		%13 = load i1, i1* %12

	; VarValue
	%14 = alloca i32
	store i32 0, i32* %14
	%15 = load i32, i32* %14
	
	ret i32 %15
}

; Method main2
define i32 @main2(%struct.Main*, i8*) #0 {
	; Formals
	%3 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %3
	%4 = alloca i8*
	store i8* %1, i8** %4
	
	; VarValue
	%5 = alloca i32
	store i32 0, i32* %5
	%6 = load i32, i32* %5
	
	ret i32 %6
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
