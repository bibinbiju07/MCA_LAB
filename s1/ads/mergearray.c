#include<stdio.h>
void main()
{
	int a[10],b[10],c[10],i,j,n,temp;
	printf("\nEnter the size of array : ");
	scanf("%d",&n);
	printf("\nenter the elements in  the first array : ");
	for(i=0;i<n;++i)
		scanf("%d",&a[i]);
	printf("\nenter the elements in  the second array : ");
	for(i=0;i<n;++i)
		scanf("%d",&b[i]);
	for(i=0;i<n;++i)
	c[i]=a[i];
	for(j=0;j<=n;++j)
	c[i]=b[i];
	i++;
for(i=0;i<=n;++i)
{
 temp=c[i];
c[i]=c[i+1];
c[i+1]=temp;
}
printf("merged array is");
	for(i=0;i<=n;++i)
	printf("\n%d",c[i]);	
}


