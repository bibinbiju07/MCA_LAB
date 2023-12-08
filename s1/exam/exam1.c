#include<stdio.h>
#include<stdlib.h>
int a[10],front=-1,rear=-1,n;
void insert();
void del();
void display();

void main()
{
 int ch;
printf("enter the size\n");
scanf("%d",&n);
while(1)
{
 printf("\n1.insert\n 2.delete\n 3.display\n 4.exit\n");
printf("enter your choice:\n");
scanf("%d",&ch);
switch(ch)
{
 case 1:
insert();
break;
case 2:
del();
break;
case 3:
display();
break;
case 4:
exit(0);
break;
default:
printf("invalid choice\n");
}
}
}

void insert()
{
 int x;
if((front==0 && rear==n-1) || (front==rear+1))
printf("full\n");
else
{
printf("enter the element");
scanf("%d",&x);
 if(front==-1 && rear==-1)
front=rear=0;
else if(rear==n-1 && front!=0)
rear=0;
else
rear=(rear+1);
a[rear]=x;
}
}

void display()
{
int i;

 if(front==-1)
printf("empty");
else
{
if(front<=rear)
{
 for(i=front;i<=rear;i++)
{
 printf("%d",a[i]);
}
}
else
{
 for(i=front;i<n;i++)
  printf("%d",a[i]);
 for(i=0;i<=rear;i++)
 printf("%d",a[i]);
}
}
}

void del()
{
 if(front==-1)
printf("empty");
else
 if(front==rear)
front=rear=-1;
else if(front==n-1)
 front=0;
else
front +=1;
}
