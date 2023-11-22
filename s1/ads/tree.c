#include<stdio.h>
#include<stdlib.h>
struct node
{
 struct node *left;
 struct node *right;
int data;
};
struct node *root;
struct node *newnode( int value)
{
 struct node *newnode=malloc(sizeof(struct node));
newnode->data=value;
newnode->left=NULL;
newnode->right=NULL;
return newnode;
}

struct node *insert(struct node *root,int value)
{
if(root==NULL)
{
 return newnode(value);
}
else if(value==root->data)
{
 printf("same data cant be stored");
}
else if(value>root->data)
{
 root->right=insert(root->right,value);
}
else if(value<root->data)
{
 root->left=insert(root->left,value);
}
return root;
}


void inordertraversal(struct node *root)
{
 if(root==NULL)return;
inordertraversal(root->left);
printf("%d->",root->data);
inordertraversal(root->right);
}


void preordertraversal(struct node *root)
{
 if(root==NULL)return;
printf("%d->",root->data);
preordertraversal(root->left);
preordertraversal(root->right);
}


void postordertraversal(struct node *root)
{
 if(root==NULL)return;

postordertraversal(root->left);
postordertraversal(root->right);
printf("%d->",root->data);
}


struct node *search(struct node *root,int key)
{
 if(root==NULL)
printf("not found");
else if(root->data==key)
printf("found");
else
{
 if(root->data<key)
return search(root->right,key);
return search(root->left,key);
}
}

struct node *minvaluenode(struct node *node)
{
 struct node *current=node;
while(current&&current->left!=NULL)
current=current->left;
return current;
}


struct node *deletenode(struct node *root,int key)
{
 if(root==NULL)
return root;
if(key<root->data)
root->left=deletenode(root->left,key);
else if(key>root->data)
root->right=deletenode(root->right,key);
else
{
 if(root->left==NULL)
{
 struct node *temp=root->right;
free(root);
return temp;
}
else if(root->right==NULL)
{
 struct node *temp=root->left;
free(root);
return temp;
}
struct node *temp=minvaluenode(root->right);
root->data=temp->data;
root->right=deletenode(root->right,temp->data);
}
return root;
}


void main()
{
int opt;
int value,searchv,key;
do
{
 printf("\n1.create root node \n2.insert node \n3.search \n4.inorder traversal \n5.preorder traversal \n6.postorder traversal \n7.delete \n8.exit\n");
printf("choose option:\n");
scanf("%d",&opt);
switch(opt)
{
 case 1:
printf("enter a  number\n");
scanf("%d",&value);
root=newnode(value);
break;
 case 2:
printf("enter a  number\n");
scanf("%d",&value);
root=insert(root,value);
break;
 case 3:
printf("enter a  number\n");
scanf("%d",&searchv);
search(root,searchv);
break;
 case 4:
printf("\n...........\n");
inordertraversal(root);
printf("\n...........\n");
break;
case 5:
printf("\n...........\n");
preordertraversal(root);
printf("\n...........\n");
break;
case 6:
printf("\n...........\n");
postordertraversal(root);
printf("\n...........\n");
break;
 case 7:
printf("enter a  number to be deleted\n");
scanf("%d",&key);
deletenode(root,key);
break;
default:
 printf("invalid option");
}
}while(opt!=8);
}
