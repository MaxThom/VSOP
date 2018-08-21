; ModuleID = 'Test1.vsop'
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
	%struct.IO,
	i32
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
	store i32 0, i32* %6

	ret void
}

; Method guessN
define void @Main_guessN(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	store %struct.Main* %0, %struct.Main** %2
	
	; Call Method
	%3 = load %struct.Main*, %struct.Main** %2
	%4 = getelementptr inbounds %struct.Main, %struct.Main* %3, i32 0, i32 0
	; Arguments
	; VarValue
	%5 = alloca [5 x i8]
	store [5 x i8] c"n = \00", [5 x i8]* %5
	%6 = bitcast [5 x i8]* %5 to i8*
	
	%7 = call %struct.IO* @IO_print(%struct.IO* %4, i8* %6)
	; Arguments
	; ObjectIdentifier
	%8 = load %struct.Main*, %struct.Main** %2
	%9 = getelementptr inbounds %struct.Main, %struct.Main* %8, i32 0, i32 1
	%10 = load i32, i32* %9

	%11 = call %struct.IO* @IO_printInt32(%struct.IO* %7, i32 %10)
	; Arguments
	; VarValue
	%12 = alloca [12 x i8]
	store [12 x i8] c", guess is \00", [12 x i8]* %12
	%13 = bitcast [12 x i8]* %12 to i8*
	
	%14 = call %struct.IO* @IO_print(%struct.IO* %11, i8* %13)

	; If
	; ObjectIdentifier
	%15 = load %struct.Main*, %struct.Main** %2
	%16 = getelementptr inbounds %struct.Main, %struct.Main* %15, i32 0, i32 1
	%17 = load i32, i32* %16

	; VarValue
	%18 = alloca i32
	store i32 0, i32* %18
	%19 = load i32, i32* %18
	
	; Lower
	%20 = icmp slt i32 %17, %19

	br i1 %20, label %condIf1, label %condElse1	

	condIf1:
		; Call Method
		%21 = load %struct.Main*, %struct.Main** %2
		%22 = getelementptr inbounds %struct.Main, %struct.Main* %21, i32 0, i32 0
		; Arguments
		; VarValue
		%23 = alloca [6 x i8]
		store [6 x i8] c"n < 0\00", [6 x i8]* %23
		%24 = bitcast [6 x i8]* %23 to i8*
		
		%25 = call %struct.IO* @IO_print(%struct.IO* %22, i8* %24)

		br label %condEnd1

	condElse1:
		; If
		; VarValue
		%26 = alloca i32
		store i32 100, i32* %26
		%27 = load i32, i32* %26
		
		; ObjectIdentifier
		%28 = load %struct.Main*, %struct.Main** %2
		%29 = getelementptr inbounds %struct.Main, %struct.Main* %28, i32 0, i32 1
		%30 = load i32, i32* %29

		; Lower
		%31 = icmp slt i32 %27, %30

		br i1 %31, label %condIf2, label %condElse2		

		condIf2:
			; Call Method
			%32 = load %struct.Main*, %struct.Main** %2
			%33 = getelementptr inbounds %struct.Main, %struct.Main* %32, i32 0, i32 0
			; Arguments
			; VarValue
			%34 = alloca [8 x i8]
			store [8 x i8] c"n > 100\00", [8 x i8]* %34
			%35 = bitcast [8 x i8]* %34 to i8*
			
			%36 = call %struct.IO* @IO_print(%struct.IO* %33, i8* %35)

			br label %condEnd2

		condElse2:
			; If
			; ObjectIdentifier
			%37 = load %struct.Main*, %struct.Main** %2
			%38 = getelementptr inbounds %struct.Main, %struct.Main* %37, i32 0, i32 1
			%39 = load i32, i32* %38

			; VarValue
			%40 = alloca i32
			store i32 50, i32* %40
			%41 = load i32, i32* %40
			
			; Lower
			%42 = icmp slt i32 %39, %41

			br i1 %42, label %condIf3, label %condElse3			

			condIf3:
				; If
				; ObjectIdentifier
				%43 = load %struct.Main*, %struct.Main** %2
				%44 = getelementptr inbounds %struct.Main, %struct.Main* %43, i32 0, i32 1
				%45 = load i32, i32* %44

				; VarValue
				%46 = alloca i32
				store i32 25, i32* %46
				%47 = load i32, i32* %46
				
				; Lower
				%48 = icmp slt i32 %45, %47

				br i1 %48, label %condIf4, label %condElse4				

				condIf4:
					; If
					; ObjectIdentifier
					%49 = load %struct.Main*, %struct.Main** %2
					%50 = getelementptr inbounds %struct.Main, %struct.Main* %49, i32 0, i32 1
					%51 = load i32, i32* %50

					; VarValue
					%52 = alloca i32
					store i32 12, i32* %52
					%53 = load i32, i32* %52
					
					; Lower
					%54 = icmp slt i32 %51, %53

					br i1 %54, label %condIf5, label %condElse5					

					condIf5:
						; If
						; ObjectIdentifier
						%55 = load %struct.Main*, %struct.Main** %2
						%56 = getelementptr inbounds %struct.Main, %struct.Main* %55, i32 0, i32 1
						%57 = load i32, i32* %56

						; VarValue
						%58 = alloca i32
						store i32 6, i32* %58
						%59 = load i32, i32* %58
						
						; Lower
						%60 = icmp slt i32 %57, %59

						br i1 %60, label %condIf6, label %condElse6						

						condIf6:
							; If
							; ObjectIdentifier
							%61 = load %struct.Main*, %struct.Main** %2
							%62 = getelementptr inbounds %struct.Main, %struct.Main* %61, i32 0, i32 1
							%63 = load i32, i32* %62

							; VarValue
							%64 = alloca i32
							store i32 3, i32* %64
							%65 = load i32, i32* %64
							
							; Lower
							%66 = icmp slt i32 %63, %65

							br i1 %66, label %condIf7, label %condElse7							

							condIf7:
								; If
								; ObjectIdentifier
								%67 = load %struct.Main*, %struct.Main** %2
								%68 = getelementptr inbounds %struct.Main, %struct.Main* %67, i32 0, i32 1
								%69 = load i32, i32* %68

								; VarValue
								%70 = alloca i32
								store i32 2, i32* %70
								%71 = load i32, i32* %70
								
								; Lower
								%72 = icmp slt i32 %69, %71

								br i1 %72, label %condIf8, label %condElse8								

								condIf8:
									; If
									; ObjectIdentifier
									%73 = load %struct.Main*, %struct.Main** %2
									%74 = getelementptr inbounds %struct.Main, %struct.Main* %73, i32 0, i32 1
									%75 = load i32, i32* %74

									; VarValue
									%76 = alloca i32
									store i32 1, i32* %76
									%77 = load i32, i32* %76
									
									; Lower
									%78 = icmp slt i32 %75, %77

									br i1 %78, label %condIf9, label %condElse9									

									condIf9:
										; Call Method
										%79 = load %struct.Main*, %struct.Main** %2
										%80 = getelementptr inbounds %struct.Main, %struct.Main* %79, i32 0, i32 0
										; Arguments
										; VarValue
										%81 = alloca [6 x i8]
										store [6 x i8] c"n = 0\00", [6 x i8]* %81
										%82 = bitcast [6 x i8]* %81 to i8*
										
										%83 = call %struct.IO* @IO_print(%struct.IO* %80, i8* %82)

										br label %condEnd9

									condElse9:
										; Call Method
										%84 = load %struct.Main*, %struct.Main** %2
										%85 = getelementptr inbounds %struct.Main, %struct.Main* %84, i32 0, i32 0
										; Arguments
										; VarValue
										%86 = alloca [6 x i8]
										store [6 x i8] c"n = 1\00", [6 x i8]* %86
										%87 = bitcast [6 x i8]* %86 to i8*
										
										%88 = call %struct.IO* @IO_print(%struct.IO* %85, i8* %87)

										br label %condEnd9

									condEnd9:
										%89 = phi %struct.IO* [%83, %condIf9], [%88, %condElse9]

									br label %condEnd8

								condElse8:
									; Call Method
									%90 = load %struct.Main*, %struct.Main** %2
									%91 = getelementptr inbounds %struct.Main, %struct.Main* %90, i32 0, i32 0
									; Arguments
									; VarValue
									%92 = alloca [6 x i8]
									store [6 x i8] c"n = 2\00", [6 x i8]* %92
									%93 = bitcast [6 x i8]* %92 to i8*
									
									%94 = call %struct.IO* @IO_print(%struct.IO* %91, i8* %93)

									br label %condEnd8

								condEnd8:
									%95 = phi %struct.IO* [%89, %condEnd9], [%94, %condElse8]

								br label %condEnd7

							condElse7:
								; If
								; ObjectIdentifier
								%96 = load %struct.Main*, %struct.Main** %2
								%97 = getelementptr inbounds %struct.Main, %struct.Main* %96, i32 0, i32 1
								%98 = load i32, i32* %97

								; VarValue
								%99 = alloca i32
								store i32 4, i32* %99
								%100 = load i32, i32* %99
								
								; Lower
								%101 = icmp slt i32 %98, %100

								br i1 %101, label %condIf10, label %condElse10								

								condIf10:
									; Call Method
									%102 = load %struct.Main*, %struct.Main** %2
									%103 = getelementptr inbounds %struct.Main, %struct.Main* %102, i32 0, i32 0
									; Arguments
									; VarValue
									%104 = alloca [6 x i8]
									store [6 x i8] c"n = 3\00", [6 x i8]* %104
									%105 = bitcast [6 x i8]* %104 to i8*
									
									%106 = call %struct.IO* @IO_print(%struct.IO* %103, i8* %105)

									br label %condEnd10

								condElse10:
									; If
									; ObjectIdentifier
									%107 = load %struct.Main*, %struct.Main** %2
									%108 = getelementptr inbounds %struct.Main, %struct.Main* %107, i32 0, i32 1
									%109 = load i32, i32* %108

									; VarValue
									%110 = alloca i32
									store i32 5, i32* %110
									%111 = load i32, i32* %110
									
									; Lower
									%112 = icmp slt i32 %109, %111

									br i1 %112, label %condIf11, label %condElse11									

									condIf11:
										; Call Method
										%113 = load %struct.Main*, %struct.Main** %2
										%114 = getelementptr inbounds %struct.Main, %struct.Main* %113, i32 0, i32 0
										; Arguments
										; VarValue
										%115 = alloca [6 x i8]
										store [6 x i8] c"n = 4\00", [6 x i8]* %115
										%116 = bitcast [6 x i8]* %115 to i8*
										
										%117 = call %struct.IO* @IO_print(%struct.IO* %114, i8* %116)

										br label %condEnd11

									condElse11:
										; Call Method
										%118 = load %struct.Main*, %struct.Main** %2
										%119 = getelementptr inbounds %struct.Main, %struct.Main* %118, i32 0, i32 0
										; Arguments
										; VarValue
										%120 = alloca [6 x i8]
										store [6 x i8] c"n = 5\00", [6 x i8]* %120
										%121 = bitcast [6 x i8]* %120 to i8*
										
										%122 = call %struct.IO* @IO_print(%struct.IO* %119, i8* %121)

										br label %condEnd11

									condEnd11:
										%123 = phi %struct.IO* [%117, %condIf11], [%122, %condElse11]

									br label %condEnd10

								condEnd10:
									%124 = phi %struct.IO* [%106, %condIf10], [%123, %condEnd11]

								br label %condEnd7

							condEnd7:
								%125 = phi %struct.IO* [%95, %condEnd8], [%124, %condEnd10]

							br label %condEnd6

						condElse6:
							; If
							; ObjectIdentifier
							%126 = load %struct.Main*, %struct.Main** %2
							%127 = getelementptr inbounds %struct.Main, %struct.Main* %126, i32 0, i32 1
							%128 = load i32, i32* %127

							; VarValue
							%129 = alloca i32
							store i32 9, i32* %129
							%130 = load i32, i32* %129
							
							; Lower
							%131 = icmp slt i32 %128, %130

							br i1 %131, label %condIf12, label %condElse12							

							condIf12:
								; If
								; ObjectIdentifier
								%132 = load %struct.Main*, %struct.Main** %2
								%133 = getelementptr inbounds %struct.Main, %struct.Main* %132, i32 0, i32 1
								%134 = load i32, i32* %133

								; VarValue
								%135 = alloca i32
								store i32 7, i32* %135
								%136 = load i32, i32* %135
								
								; Lower
								%137 = icmp slt i32 %134, %136

								br i1 %137, label %condIf13, label %condElse13								

								condIf13:
									; Call Method
									%138 = load %struct.Main*, %struct.Main** %2
									%139 = getelementptr inbounds %struct.Main, %struct.Main* %138, i32 0, i32 0
									; Arguments
									; VarValue
									%140 = alloca [6 x i8]
									store [6 x i8] c"n = 6\00", [6 x i8]* %140
									%141 = bitcast [6 x i8]* %140 to i8*
									
									%142 = call %struct.IO* @IO_print(%struct.IO* %139, i8* %141)

									br label %condEnd13

								condElse13:
									; If
									; ObjectIdentifier
									%143 = load %struct.Main*, %struct.Main** %2
									%144 = getelementptr inbounds %struct.Main, %struct.Main* %143, i32 0, i32 1
									%145 = load i32, i32* %144

									; VarValue
									%146 = alloca i32
									store i32 8, i32* %146
									%147 = load i32, i32* %146
									
									; Lower
									%148 = icmp slt i32 %145, %147

									br i1 %148, label %condIf14, label %condElse14									

									condIf14:
										; Call Method
										%149 = load %struct.Main*, %struct.Main** %2
										%150 = getelementptr inbounds %struct.Main, %struct.Main* %149, i32 0, i32 0
										; Arguments
										; VarValue
										%151 = alloca [6 x i8]
										store [6 x i8] c"n = 7\00", [6 x i8]* %151
										%152 = bitcast [6 x i8]* %151 to i8*
										
										%153 = call %struct.IO* @IO_print(%struct.IO* %150, i8* %152)

										br label %condEnd14

									condElse14:
										; Call Method
										%154 = load %struct.Main*, %struct.Main** %2
										%155 = getelementptr inbounds %struct.Main, %struct.Main* %154, i32 0, i32 0
										; Arguments
										; VarValue
										%156 = alloca [6 x i8]
										store [6 x i8] c"n = 8\00", [6 x i8]* %156
										%157 = bitcast [6 x i8]* %156 to i8*
										
										%158 = call %struct.IO* @IO_print(%struct.IO* %155, i8* %157)

										br label %condEnd14

									condEnd14:
										%159 = phi %struct.IO* [%153, %condIf14], [%158, %condElse14]

									br label %condEnd13

								condEnd13:
									%160 = phi %struct.IO* [%142, %condIf13], [%159, %condEnd14]

								br label %condEnd12

							condElse12:
								; If
								; ObjectIdentifier
								%161 = load %struct.Main*, %struct.Main** %2
								%162 = getelementptr inbounds %struct.Main, %struct.Main* %161, i32 0, i32 1
								%163 = load i32, i32* %162

								; VarValue
								%164 = alloca i32
								store i32 10, i32* %164
								%165 = load i32, i32* %164
								
								; Lower
								%166 = icmp slt i32 %163, %165

								br i1 %166, label %condIf15, label %condElse15								

								condIf15:
									; Call Method
									%167 = load %struct.Main*, %struct.Main** %2
									%168 = getelementptr inbounds %struct.Main, %struct.Main* %167, i32 0, i32 0
									; Arguments
									; VarValue
									%169 = alloca [6 x i8]
									store [6 x i8] c"n = 9\00", [6 x i8]* %169
									%170 = bitcast [6 x i8]* %169 to i8*
									
									%171 = call %struct.IO* @IO_print(%struct.IO* %168, i8* %170)

									br label %condEnd15

								condElse15:
									; If
									; ObjectIdentifier
									%172 = load %struct.Main*, %struct.Main** %2
									%173 = getelementptr inbounds %struct.Main, %struct.Main* %172, i32 0, i32 1
									%174 = load i32, i32* %173

									; VarValue
									%175 = alloca i32
									store i32 11, i32* %175
									%176 = load i32, i32* %175
									
									; Lower
									%177 = icmp slt i32 %174, %176

									br i1 %177, label %condIf16, label %condElse16									

									condIf16:
										; Call Method
										%178 = load %struct.Main*, %struct.Main** %2
										%179 = getelementptr inbounds %struct.Main, %struct.Main* %178, i32 0, i32 0
										; Arguments
										; VarValue
										%180 = alloca [7 x i8]
										store [7 x i8] c"n = 10\00", [7 x i8]* %180
										%181 = bitcast [7 x i8]* %180 to i8*
										
										%182 = call %struct.IO* @IO_print(%struct.IO* %179, i8* %181)

										br label %condEnd16

									condElse16:
										; Call Method
										%183 = load %struct.Main*, %struct.Main** %2
										%184 = getelementptr inbounds %struct.Main, %struct.Main* %183, i32 0, i32 0
										; Arguments
										; VarValue
										%185 = alloca [7 x i8]
										store [7 x i8] c"n = 11\00", [7 x i8]* %185
										%186 = bitcast [7 x i8]* %185 to i8*
										
										%187 = call %struct.IO* @IO_print(%struct.IO* %184, i8* %186)

										br label %condEnd16

									condEnd16:
										%188 = phi %struct.IO* [%182, %condIf16], [%187, %condElse16]

									br label %condEnd15

								condEnd15:
									%189 = phi %struct.IO* [%171, %condIf15], [%188, %condEnd16]

								br label %condEnd12

							condEnd12:
								%190 = phi %struct.IO* [%160, %condEnd13], [%189, %condEnd15]

							br label %condEnd6

						condEnd6:
							%191 = phi %struct.IO* [%125, %condEnd7], [%190, %condEnd12]

						br label %condEnd5

					condElse5:
						; Call Method
						%192 = load %struct.Main*, %struct.Main** %2
						%193 = getelementptr inbounds %struct.Main, %struct.Main* %192, i32 0, i32 0
						; Arguments
						; VarValue
						%194 = alloca [13 x i8]
						store [13 x i8] c"12 <= n < 25\00", [13 x i8]* %194
						%195 = bitcast [13 x i8]* %194 to i8*
						
						%196 = call %struct.IO* @IO_print(%struct.IO* %193, i8* %195)

						br label %condEnd5

					condEnd5:
						%197 = phi %struct.IO* [%191, %condEnd6], [%196, %condElse5]

					br label %condEnd4

				condElse4:
					; Call Method
					%198 = load %struct.Main*, %struct.Main** %2
					%199 = getelementptr inbounds %struct.Main, %struct.Main* %198, i32 0, i32 0
					; Arguments
					; VarValue
					%200 = alloca [13 x i8]
					store [13 x i8] c"25 <= n < 50\00", [13 x i8]* %200
					%201 = bitcast [13 x i8]* %200 to i8*
					
					%202 = call %struct.IO* @IO_print(%struct.IO* %199, i8* %201)

					br label %condEnd4

				condEnd4:
					%203 = phi %struct.IO* [%197, %condEnd5], [%202, %condElse4]

				br label %condEnd3

			condElse3:
				; Call Method
				%204 = load %struct.Main*, %struct.Main** %2
				%205 = getelementptr inbounds %struct.Main, %struct.Main* %204, i32 0, i32 0
				; Arguments
				; VarValue
				%206 = alloca [15 x i8]
				store [15 x i8] c"50 <= n <= 100\00", [15 x i8]* %206
				%207 = bitcast [15 x i8]* %206 to i8*
				
				%208 = call %struct.IO* @IO_print(%struct.IO* %205, i8* %207)

				br label %condEnd3

			condEnd3:
				%209 = phi %struct.IO* [%203, %condEnd4], [%208, %condElse3]

			br label %condEnd2

		condEnd2:
			%210 = phi %struct.IO* [%36, %condIf2], [%209, %condEnd3]

		br label %condEnd1

	condEnd1:
		%211 = phi %struct.IO* [%25, %condIf1], [%210, %condEnd2]

	; Call Method
	%212 = load %struct.Main*, %struct.Main** %2
	%213 = getelementptr inbounds %struct.Main, %struct.Main* %212, i32 0, i32 0
	; Arguments
	; VarValue
	%214 = alloca [2 x i8]
	store [2 x i8] c"\0a\00", [2 x i8]* %214
	%215 = bitcast [2 x i8]* %214 to i8*
	
	%216 = call %struct.IO* @IO_print(%struct.IO* %213, i8* %215)

	ret void
}

; Method main
define i32 @main(%struct.Main*) #0 {
	; Formals
	%2 = alloca %struct.Main*
	%3 = call %struct.Main* @Main_new()
	store %struct.Main* %3, %struct.Main** %2
	
	; Call Method
	%4 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %4)

	; ObjectIdentifier
	%5 = load %struct.Main*, %struct.Main** %2
	%6 = getelementptr inbounds %struct.Main, %struct.Main* %5, i32 0, i32 1
	%7 = load i32, i32* %6

	; VarValue
	%8 = alloca i32
	store i32 1, i32* %8
	%9 = load i32, i32* %8
	
	; Assign
	store i32 %9, i32* %6
	
	; ObjectIdentifier
	%10 = load %struct.Main*, %struct.Main** %2
	%11 = getelementptr inbounds %struct.Main, %struct.Main* %10, i32 0, i32 1
	%12 = load i32, i32* %11

	; Call Method
	%13 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %13)

	; ObjectIdentifier
	%14 = load %struct.Main*, %struct.Main** %2
	%15 = getelementptr inbounds %struct.Main, %struct.Main* %14, i32 0, i32 1
	%16 = load i32, i32* %15

	; VarValue
	%17 = alloca i32
	store i32 2, i32* %17
	%18 = load i32, i32* %17
	
	; Assign
	store i32 %18, i32* %15
	
	; ObjectIdentifier
	%19 = load %struct.Main*, %struct.Main** %2
	%20 = getelementptr inbounds %struct.Main, %struct.Main* %19, i32 0, i32 1
	%21 = load i32, i32* %20

	; Call Method
	%22 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %22)

	; ObjectIdentifier
	%23 = load %struct.Main*, %struct.Main** %2
	%24 = getelementptr inbounds %struct.Main, %struct.Main* %23, i32 0, i32 1
	%25 = load i32, i32* %24

	; VarValue
	%26 = alloca i32
	store i32 4, i32* %26
	%27 = load i32, i32* %26
	
	; Assign
	store i32 %27, i32* %24
	
	; ObjectIdentifier
	%28 = load %struct.Main*, %struct.Main** %2
	%29 = getelementptr inbounds %struct.Main, %struct.Main* %28, i32 0, i32 1
	%30 = load i32, i32* %29

	; Call Method
	%31 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %31)

	; ObjectIdentifier
	%32 = load %struct.Main*, %struct.Main** %2
	%33 = getelementptr inbounds %struct.Main, %struct.Main* %32, i32 0, i32 1
	%34 = load i32, i32* %33

	; VarValue
	%35 = alloca i32
	store i32 8, i32* %35
	%36 = load i32, i32* %35
	
	; Assign
	store i32 %36, i32* %33
	
	; ObjectIdentifier
	%37 = load %struct.Main*, %struct.Main** %2
	%38 = getelementptr inbounds %struct.Main, %struct.Main* %37, i32 0, i32 1
	%39 = load i32, i32* %38

	; Call Method
	%40 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %40)

	; ObjectIdentifier
	%41 = load %struct.Main*, %struct.Main** %2
	%42 = getelementptr inbounds %struct.Main, %struct.Main* %41, i32 0, i32 1
	%43 = load i32, i32* %42

	; VarValue
	%44 = alloca i32
	store i32 16, i32* %44
	%45 = load i32, i32* %44
	
	; Assign
	store i32 %45, i32* %42
	
	; ObjectIdentifier
	%46 = load %struct.Main*, %struct.Main** %2
	%47 = getelementptr inbounds %struct.Main, %struct.Main* %46, i32 0, i32 1
	%48 = load i32, i32* %47

	; Call Method
	%49 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %49)

	; ObjectIdentifier
	%50 = load %struct.Main*, %struct.Main** %2
	%51 = getelementptr inbounds %struct.Main, %struct.Main* %50, i32 0, i32 1
	%52 = load i32, i32* %51

	; VarValue
	%53 = alloca i32
	store i32 32, i32* %53
	%54 = load i32, i32* %53
	
	; Assign
	store i32 %54, i32* %51
	
	; ObjectIdentifier
	%55 = load %struct.Main*, %struct.Main** %2
	%56 = getelementptr inbounds %struct.Main, %struct.Main* %55, i32 0, i32 1
	%57 = load i32, i32* %56

	; Call Method
	%58 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %58)

	; ObjectIdentifier
	%59 = load %struct.Main*, %struct.Main** %2
	%60 = getelementptr inbounds %struct.Main, %struct.Main* %59, i32 0, i32 1
	%61 = load i32, i32* %60

	; VarValue
	%62 = alloca i32
	store i32 64, i32* %62
	%63 = load i32, i32* %62
	
	; Assign
	store i32 %63, i32* %60
	
	; ObjectIdentifier
	%64 = load %struct.Main*, %struct.Main** %2
	%65 = getelementptr inbounds %struct.Main, %struct.Main* %64, i32 0, i32 1
	%66 = load i32, i32* %65

	; Call Method
	%67 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %67)

	; ObjectIdentifier
	%68 = load %struct.Main*, %struct.Main** %2
	%69 = getelementptr inbounds %struct.Main, %struct.Main* %68, i32 0, i32 1
	%70 = load i32, i32* %69

	; VarValue
	%71 = alloca i32
	store i32 128, i32* %71
	%72 = load i32, i32* %71
	
	; Assign
	store i32 %72, i32* %69
	
	; ObjectIdentifier
	%73 = load %struct.Main*, %struct.Main** %2
	%74 = getelementptr inbounds %struct.Main, %struct.Main* %73, i32 0, i32 1
	%75 = load i32, i32* %74

	; Call Method
	%76 = load %struct.Main*, %struct.Main** %2
	call void @Main_guessN(%struct.Main* %76)

	; VarValue
	%77 = alloca i32
	store i32 0, i32* %77
	%78 = load i32, i32* %77
	
	ret i32 %78
}

