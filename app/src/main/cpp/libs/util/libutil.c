/* Filename: lib_util.c */
#include<stdio.h>
#include<string.h>
#include<math.h>
#include "libutil.h"

int  getSum(int a, int b)
{
  return a + b;
}

int charArrayToInt(char *arr) {
  int i, value, r, flag;

  flag = 1;
  i = value = 0;

  for( i = 0 ; i<strlen(arr) ; ++i){

    // if arr contain negative number
    if( i==0 && arr[i]=='-' ){
      flag = -1;
      continue;
    }

    r = arr[i] - '0';
    value = value * 10 + r;
  }

  value = value * flag;

  return value;

}