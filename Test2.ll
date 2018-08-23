; ModuleID = 'Test2.vsop'
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
%struct.IO = type {
	%struct.Object
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
	
	; If
	; Or
	br label %Or1.1
	Or1.1:
		; Call Method
		%4 = load %struct.Main*, %struct.Main** %2
		%5 = getelementptr inbounds %struct.Main, %struct.Main* %4, i32 0, i32 0
		; Arguments
		; VarValue
		%6 = alloca i32
		store i32 1, i32* %6
		%7 = load i32, i32* %6
		
		%8 = call %struct.IO* @IO_printlnInt32(%struct.IO* %5, i32 %7)

		; VarValue
		%9 = alloca i1
		store i1 0, i1* %9
		%10 = load i1, i1* %9
		
	br i1 %10, label %OrEnd1, label %Or1.2
	Or1.2:
		; Call Method
		%11 = load %struct.Main*, %struct.Main** %2
		%12 = getelementptr inbounds %struct.Main, %struct.Main* %11, i32 0, i32 0
		; Arguments
		; VarValue
		%13 = alloca i32
		store i32 2, i32* %13
		%14 = load i32, i32* %13
		
		%15 = call %struct.IO* @IO_printlnInt32(%struct.IO* %12, i32 %14)

		; Or
		br label %Or2.1
		Or2.1:
		; Or
		br label %Or3.1
		Or3.1:
		; VarValue
		%16 = alloca i1
		store i1 0, i1* %16
		%17 = load i1, i1* %16
		
		br i1 %17, label %OrEnd3, label %Or3.2
		Or3.2:
		; VarValue
		%18 = alloca i1
		store i1 0, i1* %18
		%19 = load i1, i1* %18
		
		%20 = or i1 %17, %19
		br label %OrEnd3
		OrEnd3:
		%21 = phi i1 [%17, %Or3.1], [%20, %Or3.2]

		br i1 %21, label %OrEnd2, label %Or2.2
		Or2.2:
			; Call Method
			%22 = load %struct.Main*, %struct.Main** %2
			%23 = getelementptr inbounds %struct.Main, %struct.Main* %22, i32 0, i32 0
			; Arguments
			; VarValue
			%24 = alloca [5 x i8]
			store [5 x i8] c"deep\00", [5 x i8]* %24
			%25 = bitcast [5 x i8]* %24 to i8*
			
			%26 = call %struct.IO* @IO_println(%struct.IO* %23, i8* %25)

			; Or
			br label %Or4.1
			Or4.1:
			; Or
			br label %Or5.1
			Or5.1:
			; VarValue
			%27 = alloca i1
			store i1 1, i1* %27
			%28 = load i1, i1* %27
			
			br i1 %28, label %OrEnd5, label %Or5.2
			Or5.2:
			; VarValue
			%29 = alloca i1
			store i1 1, i1* %29
			%30 = load i1, i1* %29
			
			%31 = or i1 %28, %30
			br label %OrEnd5
			OrEnd5:
			%32 = phi i1 [%28, %Or5.1], [%31, %Or5.2]

			br i1 %32, label %OrEnd4, label %Or4.2
			Or4.2:
			; VarValue
			%33 = alloca i1
			store i1 0, i1* %33
			%34 = load i1, i1* %33
			
			%35 = or i1 %32, %34
			br label %OrEnd4
			OrEnd4:
			%36 = phi i1 [%32, %OrEnd5], [%35, %Or4.2]

		%37 = or i1 %21, %36
		br label %OrEnd2
		OrEnd2:
		%38 = phi i1 [%21, %OrEnd3], [%37, %OrEnd4]

		br i1 %38, label %And1, label%condElse1
		And1:
		; Or
		br label %Or6.1
		Or6.1:
		; VarValue
		%39 = alloca i1
		store i1 0, i1* %39
		%40 = load i1, i1* %39
		
		br i1 %40, label %OrEnd6, label %Or6.2
		Or6.2:
		; VarValue
		%41 = alloca i1
		store i1 1, i1* %41
		%42 = load i1, i1* %41
		
		%43 = or i1 %40, %42
		br label %OrEnd6
		OrEnd6:
		%44 = phi i1 [%40, %Or6.1], [%43, %Or6.2]

		; And
		%45 = and i1 %38, %44

	%46 = or i1 %10, %45
	br label %OrEnd1
	OrEnd1:
	%47 = phi i1 [%10, %Or1.1], [%46, %OrEnd6]

	br i1 %47, label %condIf1, label %condElse1	

	condIf1:
			; Call Method
			%48 = load %struct.Main*, %struct.Main** %2
			%49 = getelementptr inbounds %struct.Main, %struct.Main* %48, i32 0, i32 0
			; Arguments
			; VarValue
			%50 = alloca [3 x i8]
			store [3 x i8] c"OK\00", [3 x i8]* %50
			%51 = bitcast [3 x i8]* %50 to i8*
			
			%52 = call %struct.IO* @IO_println(%struct.IO* %49, i8* %51)

			; VarValue
			%53 = alloca i32
			store i32 0, i32* %53
			%54 = load i32, i32* %53
			
		br label %condEnd1

	condElse1:
			; Call Method
			%55 = load %struct.Main*, %struct.Main** %2
			%56 = getelementptr inbounds %struct.Main, %struct.Main* %55, i32 0, i32 0
			; Arguments
			; VarValue
			%57 = alloca [3 x i8]
			store [3 x i8] c"KO\00", [3 x i8]* %57
			%58 = bitcast [3 x i8]* %57 to i8*
			
			%59 = call %struct.IO* @IO_println(%struct.IO* %56, i8* %58)

			; VarValue
			%60 = alloca i32
			store i32 0, i32* %60
			%61 = load i32, i32* %60
			
		br label %condEnd1

	condEnd1:
		%62 = phi i32 [%54, %condIf1], [%61, %condElse1]

	ret i32 %62
}

