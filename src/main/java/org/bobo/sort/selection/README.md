# 选择排序

## 使用申请额外的空间
每次把最小的元素取出，按顺序放到新数组 

实现起来也不简洁，还需要占用额外的空间

## 不使用额外的空间 原地排序
> **循环不变量**
> 
> 定义一个指针a来划分排好序的部分和未排好序的部分
> 
> `arr[0,a)`部分已排好序，`arr[a,i)`部分未排序。
> 
> 每次循环找到`arzr[a,i)`中最小的元素，与a指向的元素交换位置，a指针+1