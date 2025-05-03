
1 of 4
-------
Given a string s containing text and the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid. A string is valid if every opening parenthesis
is matched by a closing parenthesis. It can be nested also, but overlapping is not allowed.
sample string "(a{b[ Java Tutorial ]})" Example"














2 of 4
-------
What is wrong in this code

@PostMapping("/users/{id}")
public User updateUser(@PathVariable Long id, @RequestBody User user) {
    return userService.updateUser(id, user);
}

@GetMapping("/users/create")
public User createUser(@RequestBody User user) {
    return userService.createUser(user);
}









3 of 4
-------
Can you suggest a better approach for this code?

@GetMapping("/users/{id}")
public User getUser(@PathVariable Long id) {
    try {
        return userService.getUser(id);
    } catch (Exception e) {
        return null;  // Bad practice
    }
}











4 of 4
-------
How would you handle if this method returns thousands of records
@GetMapping("/users")
public List<User> getAllUsers() {
    return userRepository.findAll();  
}


--------
For some status fields, such as orderStatus, which includes:

-1 (Not Ordered)
0 (Ordered)
1 (Paid)
2 (Completed)
3 (Cancelled)

Integer orderStatus1 = new Integer(1);
Integer orderStatus2 = new Integer(1);
System.out.println(orderStatus1 == orderStatus2);

output is False
why ? is integer cache not being used? No it is used in valueOf() method

How to make it true?
String orderStatus1 = new String("1");
String orderStatus2 = new String("1");
System.out.println(Integer.valueOf(orderStatus1) == Integer.valueOf(orderStatus2));

good coding habit uses equals
// Code Explanation
Integer orderStatus1 = new Integer(1);
Integer orderStatus2 = new Integer(1);
System.out.println(orderStatus1.equals(orderStatus2));

--------
double amount1 = 0.02;
double amount2 = 0.03;
System.out.println(amount2 - amount1);

can we avoid precision loss with BigDecimal?

BigDecimal amount1 = new BigDecimal(0.02);
BigDecimal amount2 = new BigDecimal(0.03);
System.out.println(amount2.subtract(amount1));

Right thing is
BigDecimal amount1 = BigDecimal.valueOf(0.02);
BigDecimal amount2 = BigDecimal.valueOf(0.03);
System.out.println(amount2.subtract(amount1));

--------
What is the problem with this code?
String a = "123";
String b = "456";
String c = a + b;
System.out.println(c);

creates lot of intermediate objects. How to avoid - use StringBuilder or StringBuffer

what’s the difference between StringBuilder and StringBuffer?

The primary difference is that StringBuffer adds the synchronized keyword to its main methods, while StringBuilder does not. As a result:

StringBuffer is thread-safe.
StringBuilder is not thread-safe.

In practice, scenarios requiring string concatenation in multithreaded environments are rare. Consequently, StringBuffer is seldom used.

For most cases, it is recommended to use StringBuilder for string concatenation.

The append method in StringBuilder appends strings without creating intermediate objects, making it more efficient as it’s not synchronized.

String a = "123";
String b = "456";
StringBuilder c = new StringBuilder();
c.append(a).append(b);
System.out.println(c);

----------
Difference Between isEmpty and isBlank

we usually check like this
if (null != source && !"".equals(source)) {
System.out.println("not empty");
}

better to use utility methods - Spring StringUtils or Apache commons lang 3 StringUtils
Apache provides isEmpty() and isBlank() method what is the difference?

The key difference between the two methods is that for the " " empty string case,
isEmpty returns false, while isBlank returns true.

------
String source = "#ATYSDFA*Y";
if (source.indexOf("#") > 0) {
System.out.println("do something");
}
Do you think this code will print out do something?

The answer is no.
How to fix?

if (source.contains("#")) {
System.out.println("do something");
}

