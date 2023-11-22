#include<stdio.h>
#include<stdlib.h>
struct node
{
int data;
struct node *prev;
struct node *next;
};
struct node *start;

void beginsert()
{
 struct node *ptr;
int x;
ptr=(struct node *)malloc(sizeof(struct node *));
if(ptr==NULL)
{
printf("overflow");
}
else
{
 printf("enter the value\n");
scanf("%d",&x);
if(start==NULL)
{
 ptr->data=x;
ptr->prev=NULL;
ptr->next=NULL;
start=ptr;
}
else
{
 ptr->data=x;
ptr->prev=NULL;
ptr->next=start;
start->prev=ptr;
start=ptr;
}
}
} 


void lastinsert()
{
  struct node *ptr,*temp;
int x;
ptr=(struct node *)malloc(sizeof(struct node *));
if(ptr==NULL)
{
printf("overflow");
}
else
{
 printf("enter the value\n");
scanf("%d",&x);
ptr->data=x;
if(start==NULL)
{

ptr->prev=NULL;
ptr->next=NULL;
start=ptr;
}
else
{
 temp=start;
while(temp->next!=NULL)
{
 temp=temp->next;
}
temp->next=ptr;
ptr->prev=temp;
ptr->next=NULL;
}
}
}

void posinsert()
{
 struct node *ptr,*temp;
int x,pos,i;
ptr=(struct node *)malloc(sizeof(struct node));
if(ptr==NULL)
{
printf("overflow");
}
else
{
 printf("enter the value\n");
scanf("%d",&x);
ptr->data=x;
printf("enter the position\n");
scanf("%d",&pos);
temp=start;
if(pos==1)
{
 if(start==NULL)
{
 ptr->data=x;
ptr->prev=NULL;
ptr->next=NULL;
start=ptr;
}
else
{
ptr->data=x;
ptr->prev=NULL;
ptr->next=start;
start->prev=ptr;
start=ptr;
}
}
else
{
 for(i=1;i<pos-1;i++)
{
temp=temp->next;
if(temp==NULL)
{
 printf("can't insert");
}
}
ptr->next=temp->next;
temp->next=ptr;
ptr->prev=temp;
if(ptr->next!=NULL)
{
 (ptr->next)->prev=ptr;
}
}
}
}


void begdel()
{
 int x;
struct node *ptr;
if(start==NULL)
{
 printf("list empty");
} 
else
{
 ptr=start;
start=ptr->next;
start->prev=NULL;
x=ptr->data;
free(ptr);
printf("%d deleted\n",x);
}
}


void lastdel()
{
  int x;
struct node *ptr,*ptr1;
if(start==NULL)
{
 printf("list empty");
} 
else if(start->next=NULL)
{
 x=start->data;
start=NULL;
free(start);
printf("%d deleted\n",x);
}
else
{
 ptr=start;
while(ptr->next!=NULL)
{
 ptr1=ptr;
ptr=ptr->next;
}
ptr1->next=NULL;
ptr->prev=NULL;
x=ptr->data;
free(ptr);
printf("%d deleted",x);
}
}


void posdel()
{
  int pos,i,x;

struct node *ptr,*ptr1;
ptr=start;                                                                                                                                                                                                                                                            
if(start==NULL)
{
 printf("list empty");
}
else
{
 printf("enter the position\n");
scanf("%d",&pos);
if(pos==1)
{
 ptr=start;
start=ptr->next;
start->prev=NULL;
x=ptr->data;
free(ptr);
printf("%d deleted",x);
}
else
{
 for(i=1;i<pos;i++)
{
 ptr1=ptr;
ptr=ptr->next;
if(ptr==NULL)
{
 printf("can't delete");
return;
}
}
ptr1->next=ptr->next;
(ptr->next)->prev=ptr1;
x=ptr->data;
free(ptr);
printf("%d deleted",x);
}
} 
}


void search()
{
 struct node *ptr;
int x,i=0,f;
ptr=start;
if(ptr==NULL)
{
printf("list empty");
}
else
{
 printf("enter the element to search\n");
scanf("%d",&x);
while(ptr!=NULL)
{
 if(ptr->data==x)
{
printf("item found at position %d",i+1);
f=0;
break;
}
else
{
 f=1;
}
i++;
ptr=ptr->next;
}
if(f==1)
{
 printf("item not found");
}
}
}


void display()
{
 struct node *ptr;
ptr=start;
if(ptr==NULL)
{
printf("list empty");
}
else
{
 while(ptr!=NULL)
{
 printf("%d\t",ptr->data);
ptr=ptr->next;
}

}

}


void main()
{
 int ch;
while(ch!=9)
{
 printf("\n1.insert at beg \n2.insert at end \n3.insert at pos \n4.delete beg \n5.delete end \n6.delete pos \n7.search \n8.display \n9.exit\n");
printf("enter your choice\n");
scanf("%d",&ch);
switch(ch)
{
 case 1: beginsert();
break;
case 2: lastinsert();
break;
case 3: posinsert();
break;
case 4: begdel();
break;
case 5: lastdel();
break;
case 6: posdel();
break;
case 7: search();
break;
case 8: display();
break;
case 9: exit(0);
break;
default:
printf("invalid choice");
}
}
}
