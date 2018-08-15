@.printInt = private constant [3 x i8] c"%d\00"
@.printStr = private constant [3 x i8] c"%s\00"
@.printlnInt = private constant [4 x i8] c"%d\0A\00"
@.printlnStr = private constant [4 x i8] c"%s\0A\00"

declare i32 @printf(i8*, ...)

define i32 @main() {
    entry:
        %x = alloca i32
        store i32 0, i32* %x

        %x_load = load i32, i32* %x
        %cond = icmp ne i32 %x_load, 5
        br i1 %cond, label %while, label %end_while


    while:
        %x2_load = load i32, i32* %x
        %x2_add = add i32 1, %x2_load
        store i32 %x2_add, i32* %x
        call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.printlnInt, i32 0, i32 0), i32 %x2_add)

        %cond2 = icmp ne i32 %x2_add, 5        
        br i1 %cond2, label %while, label %end_while
        

    end_while:
        %str2 = alloca [10 x i8]
        store [10 x i8] c"end while\00", [10 x i8]* %str2
        %tmp2 = bitcast [10 x i8]* %str2 to i8*
        call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.printlnStr, i32 0, i32 0), i8* %tmp2)
        br label %end


    end:
        ret i32 0
}