; ModuleID = 'Test1.vsop'
source_filename = "Test1.vsop"

; 
; DECLARATION
; 
declare noalias i8* @malloc(i64) #1
declare i32 @printf(i8*, ...)
@.str.empty = private unnamed_addr constant [1 x i8] zeroinitializer, align 1

; 
; STRUCTURES
; 
%struct.Object = type { }
%struct.Main = type {
	%struct.Test2,
	i32,
	i32
}
%struct.Test2 = type {
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

	%3 = load %struct.Main*, %struct.Main** %2
	%4 = getelementptr inbounds %struct.Main, %struct.Main* %3, i32 0, i32 0
	call void @Test2_init(%struct.Test2* %4)

	%5 = load %struct.Main*, %struct.Main** %2
	%6 = getelementptr inbounds %struct.Main, %struct.Main* %5, i32 0, i32 1
	store i32 0, i32* %6

	%7 = load %struct.Main*, %struct.Main** %2
	%8 = getelementptr inbounds %struct.Main, %struct.Main* %7, i32 0, i32 2
	; VarValue
	%9 = alloca i32
	store i32 5, i32* %9
	%10 = load i32, i32* %9
	
	store i32 %10, i32* %8

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
	store i32 0, i32* %4
	%5 = load i32, i32* %4
	
	ret i32 %5
}

; Method main2
define i32 @main2(%struct.Main*, i32, i32) #0 {
	; Formals
	%4 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %4
	%5 = alloca i32
	store i32 %1, i32* %5
	%6 = alloca i32
	store i32 %2, i32* %6
	
	; ObjectIdentifier
	%7 = load %struct.Main*, %struct.Main** %4
	%8 = getelementptr inbounds %struct.Main, %struct.Main* %7, i32 0, i32 1
	%9 = load i32, i32* %8
	; Assign
	store i32 %9, i32* %5
	
	; VarValue
	%10 = alloca i32
	store i32 0, i32* %10
	%11 = load i32, i32* %10
	
	ret i32 %11
}

; 
; TEST2
; 

; Allocation
define %struct.Test2* @Test2_new() #0 {
	%size_as_ptr = getelementptr %struct.Test2, %struct.Test2* null, i32 1
	%size_as_i64 = ptrtoint %struct.Test2* %size_as_ptr to i64

	%1 = alloca %struct.Test2*
	%2 = call noalias i8* @malloc(i64 %size_as_i64) #3
	%3 = bitcast i8* %2 to %struct.Test2*
	store %struct.Test2* %3, %struct.Test2** %1

	%4 = load %struct.Test2*, %struct.Test2** %1
	call void @Test2_init(%struct.Test2* %4)

	%5 = load %struct.Test2*, %struct.Test2** %1
	ret %struct.Test2* %5
}

; Initializer
define void @Test2_init(%struct.Test2*) #0 {
	%2 = alloca %struct.Test2*
	store %struct.Test2* %0, %struct.Test2** %2

	ret void
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
