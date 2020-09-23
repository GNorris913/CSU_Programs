import math

class Complex(object):
    def __init__(self, real, imaginary):
        # Creates complex Number
        self.real = real
        self.imaginary = imaginary

    def __add__(self, no):
        # Adds complex numbers
        return Complex(self.real + no.real,
                       self.imaginary + no.imaginary)

    def __sub__(self, no):
        # Subtract Complex Numbers
        return Complex(self.real - no.real,
                       self.imaginary - no.imaginary)

    def __mul__(self, no):
        # Multiplies Complex Numbers
        return Complex(self.real * no.real - self.imaginary*no.imaginary,
                       self.imaginary * no.imaginary + self.real * no.imaginary)

    def __truediv__(self, no):
        # Divides Complex Numbers
        sr, si, ori, oi = self.real, self.imaginary, no.real, no.imaginary
        r = float(ori**2 + oi**2)
        return Complex((sr*ori+si*oi)/r, (si*ori-sr*oi)/r)

    def mod(self):
        # enter your code here
        return Complex(self.real, 0)

    def __str__(self):
        # Returns Complex Number as String
        return '(%s, %s)' % (self.real, self.imaginary)

def main():
    # put this code in a main method
    print('Enter Real and Imaginary number (separated by space): ', end='')
    C = map(float, input().split())
    print('Enter Real and Imaginary number (separated by space): ', end='')
    D = map(float, input().split())
    x = Complex(*C)
    y = Complex(*D)
    #print('\n'.join(map(str, [x + y, x - y, x * y, x / y, x.mod(), y.mod()])))
    print('Addition: ' + str(x + y))
    print('Subtraction: ' + str(x - y))
    print('Multiplication: ' + str(x * y))
    print('Division: ' + str(x / y))
    print('Modulas of complex number X: ' + str(x.mod()))
    print('Modulas of complex number Y: ' + str(y.mod()))


if __name__ == '__main__':
    main()
