javap -v -p A.class
对A.class进行反编译
================
Classfile /Users/luoyu/code/java/org.ly817/algorithm-java/src/main/java/org/ly817/jvm/classload/A.class
  Last modified 2021-8-22; size 349 bytes
  MD5 checksum ca4904b058a1dbf9e16ed5a558882547
public class org.ly817.jvm.classload.A
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #6.#16         // java/lang/Object."<init>":()V
   #2 = Class              #17            // org/ly817/jvm/classload/B
   #3 = Methodref          #2.#16         // org/ly817/jvm/classload/B."<init>":()V
   #4 = Fieldref           #5.#18         // org/ly817/jvm/classload/A.b:Lorg/ly817/jvm/classload/B;
   #5 = Class              #19            // org/ly817/jvm/classload/A
   #6 = Class              #20            // java/lang/Object
   #7 = Utf8               b
   #8 = Utf8               Lorg/ly817/jvm/classload/B;
   #9 = Utf8               <init>
  #10 = Utf8               ()V
  #11 = Utf8               Code
  #12 = Utf8               LineNumberTable
  #13 = Utf8               LocalVariableTable
  #14 = Utf8               this
  #15 = Utf8               Lorg/ly817/jvm/classload/A;
  #16 = NameAndType        #9:#10         // "<init>":()V
  #17 = Utf8               org/ly817/jvm/classload/B
  #18 = NameAndType        #7:#8          // b:Lorg/ly817/jvm/classload/B;
  #19 = Utf8               org/ly817/jvm/classload/A
  #20 = Utf8               java/lang/Object
{
  private org.ly817.jvm.classload.B b;
    descriptor: Lorg/ly817/jvm/classload/B;
    flags: ACC_PRIVATE

  public org.ly817.jvm.classload.A();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=3, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: aload_0
         5: new           #2                  // class org/ly817/jvm/classload/B
         8: dup
         9: invokespecial #3                  // Method org/ly817/jvm/classload/B."<init>":()V
        12: putfield      #4                  // Field b:Lorg/ly817/jvm/classload/B;
        15: return
      LineNumberTable:
        line 11: 0
        line 12: 4
      LocalVariableTable:
        Start  Length  Slot  Name   Signature
            0      16     0  this   Lorg/ly817/jvm/classload/A;
}
