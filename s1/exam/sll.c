#include<stdio.h>
#include<stdlib.h>
struct node
{
 int info;
struct node *link;
};
struct node *start=NULL;

void traverse()
{
struct node *temp;
  if(start==NULL)
{
 printf("list empty");
}
else
{
 temp=start;
printf("\nthe list is\n");
while(temp != NULL)
{
 printf("%d->",temp->info);
temp=temp->link;
}
}
}


void insertfront()
{
 int data;
 struct node* temp;
 temp=malloc(sizeof(struct node));
 printf("\nEnter number to be inserted:");
 scanf("%d",&data);
 temp->info=data;
 temp->link=start;
 start=temp;
}


void insertend()
{
 int data;
 struct node* temp,*head;
 temp=malloc(sizeof(struct node));
 printf("\nEnter number to be inserted:");
 scanf("%d",&data);
 temp->link=0;
 temp->info=data;
 head=start;
 while(head->link!=NULL)
 {
  head=head->link;
 }
 head->link=temp;
}


void delfront()
{
 struct node *temp;
if(start==NULL)
printf("list empty");
else
{
 temp=start;
start=start->link;
free(temp);
}
}

void delend()
{
  struct node *temp,*prevnode;
if(start==NULL)
printf("list empty");
else
{
 temp=start;
while(temp->link!=0)
{
 prevnode=temp;
temp=temp->link;
}
free(temp);
prevnode->link=0;
}
}

void search()

{
 int found=-1,key;
 struct node *tr=start;
 if(start==NULL)
 {
  printf("linked list is empty\n");
 }
 else
 {
  printf("Enter the element you want to search:");
  scanf("%d",&key);
  while(tr!=NULL)
  {
   if(tr->info==key)
   {
    found=1;
    break;
   }
   else
   {
    tr=tr->link;
   }
  }
  if(found==1)
  {
   printf( "present ");
  }
  else
  {
   printf(" not present" );
  }
 }
}


void main()
{
 int ch;
while(1)
{
 printf("\n\n1.traverse \n2.insert front \n3.insert end \n4.delete front \n5.delete end \n6.search \n7.exit\n");
printf("enter your choice:\n");
scanf("%d",&ch);

switch(ch)
{
 case 1:
traverse();
break;
case 2:
insertfront();
break;
 case 3:
insertend();
break;
case 4:
delfront();
break;
case 5:
delend();
break;
 case 6:
search();
break;
case 7:
exit(0);
break;
default:
printf("\ninvalid choice");
}
}
}
