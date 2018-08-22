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
    %2 = alloca i8*
    %3 = load i8*, i8** %2
    
    %4 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @IO.inputStr, i32 0, i32 0), i8* %3)
    %5 = load i8*, i8** %2

    ret i8* %5
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
	; ObjectIdentifier
	%4 = load %struct.Main*, %struct.Main** %2

	; ObjectIdentifier
	%5 = load %struct.Main*, %struct.Main** %2

	; Equal
	%6 = icmp eq %struct.Main* %4, %5

	br i1 %6, label %condIf1, label %condElse1	

	condIf1:
		; Call Method
		%7 = load %struct.Main*, %struct.Main** %2
		%8 = getelementptr inbounds %struct.Main, %struct.Main* %7, i32 0, i32 0
		; Arguments
		; VarValue
		%9 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %9
		%10 = bitcast [4 x i8]* %9 to i8*
		
		%11 = call %struct.IO* @IO_print(%struct.IO* %8, i8* %10)

		br label %condEnd1

	condElse1:
		; Call Method
		%12 = load %struct.Main*, %struct.Main** %2
		%13 = getelementptr inbounds %struct.Main, %struct.Main* %12, i32 0, i32 0
		; Arguments
		; VarValue
		%14 = alloca [4 x i8]
		store [4 x i8] c"KO\0a\00", [4 x i8]* %14
		%15 = bitcast [4 x i8]* %14 to i8*
		
		%16 = call %struct.IO* @IO_print(%struct.IO* %13, i8* %15)

		br label %condEnd1

	condEnd1:
		%17 = phi %struct.IO* [%11, %condIf1], [%16, %condElse1]

	; If
	; ObjectIdentifier
	%18 = load %struct.Main*, %struct.Main** %2

	; New
	%19 = alloca %struct.Main*
	%20 = call %struct.Main* @Main.new()
	store %struct.Main* %20, %struct.Main** %19

	; Equal
	%21 = icmp eq %struct.Main* %18, %20

	br i1 %21, label %condIf2, label %condElse2	

	condIf2:
		; Call Method
		%22 = load %struct.Main*, %struct.Main** %2
		%23 = getelementptr inbounds %struct.Main, %struct.Main* %22, i32 0, i32 0
		; Arguments
		; VarValue
		%24 = alloca [4 x i8]
		store [4 x i8] c"KO\0a\00", [4 x i8]* %24
		%25 = bitcast [4 x i8]* %24 to i8*
		
		%26 = call %struct.IO* @IO_print(%struct.IO* %23, i8* %25)

		br label %condEnd2

	condElse2:
		; Call Method
		%27 = load %struct.Main*, %struct.Main** %2
		%28 = getelementptr inbounds %struct.Main, %struct.Main* %27, i32 0, i32 0
		; Arguments
		; VarValue
		%29 = alloca [4 x i8]
		store [4 x i8] c"OK\0a\00", [4 x i8]* %29
		%30 = bitcast [4 x i8]* %29 to i8*
		
		%31 = call %struct.IO* @IO_print(%struct.IO* %28, i8* %30)

		br label %condEnd2

	condEnd2:
		%32 = phi %struct.IO* [%26, %condIf2], [%31, %condElse2]

	; Let
	%33 = alloca %struct.Object*
	store %struct.Object* null, %struct.Object** %33
		; If
		; ObjectIdentifier
		%34 = load %struct.Object*, %struct.Object** %33

		; ObjectIdentifier
		%35 = load %struct.Main*, %struct.Main** %2
		%36 = getelementptr inbounds %struct.Main, %struct.Main* %35, i32 0, i32 0
		%37 = getelementptr inbounds %struct.IO, %struct.IO* %36, i32 0, i32 0

		; Equal
		%38 = icmp eq %struct.Object* %34, %37

		br i1 %38, label %condIf3, label %condElse3		

		condIf3:
			; Call Method
			%39 = load %struct.Main*, %struct.Main** %2
			%40 = getelementptr inbounds %struct.Main, %struct.Main* %39, i32 0, i32 0
			; Arguments
			; VarValue
			%41 = alloca [4 x i8]
			store [4 x i8] c"KO\0a\00", [4 x i8]* %41
			%42 = bitcast [4 x i8]* %41 to i8*
			
			%43 = call %struct.IO* @IO_print(%struct.IO* %40, i8* %42)

			br label %condEnd3

		condElse3:
			; Call Method
			%44 = load %struct.Main*, %struct.Main** %2
			%45 = getelementptr inbounds %struct.Main, %struct.Main* %44, i32 0, i32 0
			; Arguments
			; VarValue
			%46 = alloca [4 x i8]
			store [4 x i8] c"OK\0a\00", [4 x i8]* %46
			%47 = bitcast [4 x i8]* %46 to i8*
			
			%48 = call %struct.IO* @IO_print(%struct.IO* %45, i8* %47)

			br label %condEnd3

		condEnd3:
			%49 = phi %struct.IO* [%43, %condIf3], [%48, %condElse3]

		; If
		; ObjectIdentifier
		%50 = load %struct.Main*, %struct.Main** %2
		%51 = getelementptr inbounds %struct.Main, %struct.Main* %50, i32 0, i32 0
		%52 = getelementptr inbounds %struct.IO, %struct.IO* %51, i32 0, i32 0

		; ObjectIdentifier
		%53 = load %struct.Object*, %struct.Object** %33

		; Equal
		%54 = icmp eq %struct.Object* %52, %53

		br i1 %54, label %condIf4, label %condElse4		

		condIf4:
			; Call Method
			%55 = load %struct.Main*, %struct.Main** %2
			%56 = getelementptr inbounds %struct.Main, %struct.Main* %55, i32 0, i32 0
			; Arguments
			; VarValue
			%57 = alloca [4 x i8]
			store [4 x i8] c"KO\0a\00", [4 x i8]* %57
			%58 = bitcast [4 x i8]* %57 to i8*
			
			%59 = call %struct.IO* @IO_print(%struct.IO* %56, i8* %58)

			br label %condEnd4

		condElse4:
			; Call Method
			%60 = load %struct.Main*, %struct.Main** %2
			%61 = getelementptr inbounds %struct.Main, %struct.Main* %60, i32 0, i32 0
			; Arguments
			; VarValue
			%62 = alloca [4 x i8]
			store [4 x i8] c"OK\0a\00", [4 x i8]* %62
			%63 = bitcast [4 x i8]* %62 to i8*
			
			%64 = call %struct.IO* @IO_print(%struct.IO* %61, i8* %63)

			br label %condEnd4

		condEnd4:
			%65 = phi %struct.IO* [%59, %condIf4], [%64, %condElse4]

		; ObjectIdentifier
		%66 = load %struct.Object*, %struct.Object** %33

		; ObjectIdentifier
		%67 = load %struct.Main*, %struct.Main** %2
		%68 = getelementptr inbounds %struct.Main, %struct.Main* %67, i32 0, i32 0
		%69 = getelementptr inbounds %struct.IO, %struct.IO* %68, i32 0, i32 0

		; Assign
		store %struct.Object* %69, %struct.Object** %33
		
		; ObjectIdentifier
		%70 = load %struct.Object*, %struct.Object** %33

		; If
		; ObjectIdentifier
		%71 = load %struct.Object*, %struct.Object** %33

		; ObjectIdentifier
		%72 = load %struct.Main*, %struct.Main** %2
		%73 = getelementptr inbounds %struct.Main, %struct.Main* %72, i32 0, i32 0
		%74 = getelementptr inbounds %struct.IO, %struct.IO* %73, i32 0, i32 0

		; Equal
		%75 = icmp eq %struct.Object* %71, %74

		br i1 %75, label %condIf5, label %condElse5		

		condIf5:
			; Call Method
			%76 = load %struct.Main*, %struct.Main** %2
			%77 = getelementptr inbounds %struct.Main, %struct.Main* %76, i32 0, i32 0
			; Arguments
			; VarValue
			%78 = alloca [4 x i8]
			store [4 x i8] c"OK\0a\00", [4 x i8]* %78
			%79 = bitcast [4 x i8]* %78 to i8*
			
			%80 = call %struct.IO* @IO_print(%struct.IO* %77, i8* %79)

			br label %condEnd5

		condElse5:
			; Call Method
			%81 = load %struct.Main*, %struct.Main** %2
			%82 = getelementptr inbounds %struct.Main, %struct.Main* %81, i32 0, i32 0
			; Arguments
			; VarValue
			%83 = alloca [4 x i8]
			store [4 x i8] c"KO\0a\00", [4 x i8]* %83
			%84 = bitcast [4 x i8]* %83 to i8*
			
			%85 = call %struct.IO* @IO_print(%struct.IO* %82, i8* %84)

			br label %condEnd5

		condEnd5:
			%86 = phi %struct.IO* [%80, %condIf5], [%85, %condElse5]

		; If
		; ObjectIdentifier
		%87 = load %struct.Main*, %struct.Main** %2
		%88 = getelementptr inbounds %struct.Main, %struct.Main* %87, i32 0, i32 0
		%89 = getelementptr inbounds %struct.IO, %struct.IO* %88, i32 0, i32 0

		; ObjectIdentifier
		%90 = load %struct.Object*, %struct.Object** %33

		; Equal
		%91 = icmp eq %struct.Object* %89, %90

		br i1 %91, label %condIf6, label %condElse6		

		condIf6:
			; Call Method
			%92 = load %struct.Main*, %struct.Main** %2
			%93 = getelementptr inbounds %struct.Main, %struct.Main* %92, i32 0, i32 0
			; Arguments
			; VarValue
			%94 = alloca [4 x i8]
			store [4 x i8] c"OK\0a\00", [4 x i8]* %94
			%95 = bitcast [4 x i8]* %94 to i8*
			
			%96 = call %struct.IO* @IO_print(%struct.IO* %93, i8* %95)

			br label %condEnd6

		condElse6:
			; Call Method
			%97 = load %struct.Main*, %struct.Main** %2
			%98 = getelementptr inbounds %struct.Main, %struct.Main* %97, i32 0, i32 0
			; Arguments
			; VarValue
			%99 = alloca [4 x i8]
			store [4 x i8] c"KO\0a\00", [4 x i8]* %99
			%100 = bitcast [4 x i8]* %99 to i8*
			
			%101 = call %struct.IO* @IO_print(%struct.IO* %98, i8* %100)

			br label %condEnd6

		condEnd6:
			%102 = phi %struct.IO* [%96, %condIf6], [%101, %condElse6]

		; VarValue
		%103 = alloca i32
		store i32 0, i32* %103
		%104 = load i32, i32* %103
		
	
	; VarValue
	%105 = alloca i32
	store i32 0, i32* %105
	%106 = load i32, i32* %105
	
	ret i32 %106
}

