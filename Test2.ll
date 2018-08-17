; ModuleID = 'Test2.vsop'
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
%struct.Parent = type {
	%struct.Object,
	i32
}
%struct.Child = type {
	%struct.Parent,
	i32
}
%struct.Main = type {
	%struct.Object,
	i32
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
	%4 = getelementptr inbounds %struct.Parent, %struct.Parent* %3, i32 0, i32 0
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
	store i32 0, i32* %4

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
	store i1 1, i1* %4
	%5 = load i1, i1* %4
	
	br i1 %5, label %condIf1, label %condElse1	

	condIf1:
		; If
		; VarValue
		%6 = alloca i1
		store i1 0, i1* %6
		%7 = load i1, i1* %6
		
		br i1 %7, label %condIf2, label %condEnd2		

		condIf2:
			; VarValue
			%8 = alloca i32
			store i32 1, i32* %8
			%9 = load i32, i32* %8
			
			br label %condEnd2

		condEnd2:
		br label %condEnd1

	condElse1:
		; VarValue
		%10 = alloca i32
		store i32 0, i32* %10
		%11 = load i32, i32* %10
		
		; While
		whileCond3:
			; VarValue
			%12 = alloca i1
			store i1 1, i1* %12
			%13 = load i1, i1* %12
			
			br i1 %13, label %while3, label %whileEnd3

		while3:
			; VarValue
			%14 = alloca i32
			store i32 1, i32* %14
			%15 = load i32, i32* %14
			
			br label %whileCond3

		whileEnd3:
		br label %condEnd1

	condEnd1:
	; If
	; VarValue
	%16 = alloca i1
	store i1 0, i1* %16
	%17 = load i1, i1* %16
	
	br i1 %17, label %condIf4, label %condElse4	

	condIf4:
		; VarValue
		%18 = alloca i32
		store i32 1, i32* %18
		%19 = load i32, i32* %18
		
		br label %condEnd4

	condElse4:
		; VarValue
		%20 = alloca i32
		store i32 2, i32* %20
		%21 = load i32, i32* %20
		
		br label %condEnd4

	condEnd4:
	; VarValue
	%22 = alloca i32
	store i32 0, i32* %22
	%23 = load i32, i32* %22
	
	ret i32 %23
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
