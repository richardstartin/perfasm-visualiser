# perfasm-visualiser

Extracts independent chains of instructions from perfasm output. Displays these chains with their cumulative profiled weight.

The following output will be derived from the perfasm output below:

```
8.27
0x00007fbfe024bc86: popcnt [r9[8/8]] -> rbx[8/8] (2.51)
  0x00007fbfe024bc80: vpextrq [0x4[4/4], %xmm6[8/16]] -> r9[8/8] (0.08)
    0x00007fbfe024bc7a: vextracti128 [0x4[4/4], %ymm11[16/32]] -> %xmm6[16/16] (2.2)
      0x00007fbfe024bb8d: vpand [0x50(%r13,%r10,8)[32/32], %ymm6[32/32]] -> %ymm11[32/32] (0.42)
        0x00007fbfe024bb81: vmovdqu [0x50(%rax,%r10,8)[32/32]] -> %ymm6[32/32] (3.06)

7.15
0x00007fbfe024bbdb: popcnt [r11[8/8]] -> r8[8/8] (2.2)
  0x00007fbfe024bbd5: vpextrq [0x4[4/4], %xmm6[8/16]] -> r11[8/8] (0.42)
    0x00007fbfe024bbcf: vextracti128 [0x4[4/4], %ymm9[16/32]] -> %xmm6[16/16] (1.45)
      0x00007fbfe024bb6c: vpand [0x70(%r13,%r10,8)[32/32], %ymm2[32/32]] -> %ymm9[32/32] (2.65)
        0x00007fbfe024bb65: vmovdqu [0x70(%rax,%r10,8)[32/32]] -> %ymm2[32/32] (0.43)

6.97
0x00007fbfe024bc72: popcnt [r9[8/8]] -> r9[8/8] (0.12)
  0x00007fbfe024bc6c: vpextrq [0x4[4/4], %xmm6[8/16]] -> r9[8/8] (1.91)
    0x00007fbfe024bc66: vextracti128 [0x4[4/4], %ymm11[16/32]] -> %xmm6[16/16] (1.46)
      0x00007fbfe024bb8d: vpand [0x50(%r13,%r10,8)[32/32], %ymm6[32/32]] -> %ymm11[32/32] (0.42)
        0x00007fbfe024bb81: vmovdqu [0x50(%rax,%r10,8)[32/32]] -> %ymm6[32/32] (3.06)

6.69
0x00007fbfe024bc13: popcnt [rdi[8/8]] -> rsi[8/8] (1.0)
  0x00007fbfe024bc0d: vpextrq [0x4[4/4], %xmm6[8/16]] -> rdi[8/8] (0.22)
    0x00007fbfe024bc07: vextracti128 [0x4[4/4], %ymm8[16/32]] -> %xmm6[16/16] (2.46)
      0x00007fbfe024bb5b: vpand [0x10(%r13,%rcx,8)[32/32], %ymm2[32/32]] -> %ymm8[32/32] (2.58)
        0x00007fbfe024bb55: vmovdqu [0x10(%rax,%rcx,8)[32/32]] -> %ymm2[32/32] (0.43)

6.5
0x00007fbfe024bc02: popcnt [rbx[8/8]] -> rbx[8/8] (1.1)
  0x00007fbfe024bbfc: vpextrq [0x4[4/4], %xmm6[8/16]] -> rbx[8/8] (0.22)
    0x00007fbfe024bbf6: vextracti128 [0x4[4/4], %ymm8[16/32]] -> %xmm6[16/16] (2.17)
      0x00007fbfe024bb5b: vpand [0x10(%r13,%rcx,8)[32/32], %ymm2[32/32]] -> %ymm8[32/32] (2.58)
        0x00007fbfe024bb55: vmovdqu [0x10(%rax,%rcx,8)[32/32]] -> %ymm2[32/32] (0.43)

6.460000000000001
0x00007fbfe024bbca: popcnt [r10[8/8]] -> r10[8/8] (2.62)
  0x00007fbfe024bbc4: vpextrq [0x4[4/4], %xmm6[8/16]] -> r10[8/8] (0.41)
    0x00007fbfe024bbbe: vextracti128 [0x4[4/4], %ymm9[16/32]] -> %xmm6[16/16] (0.35)
      0x00007fbfe024bb6c: vpand [0x70(%r13,%r10,8)[32/32], %ymm2[32/32]] -> %ymm9[32/32] (2.65)
        0x00007fbfe024bb65: vmovdqu [0x70(%rax,%r10,8)[32/32]] -> %ymm2[32/32] (0.43)

5.45
0x00007fbfe024bc60: add [%eax[4/4]] -> r14d[4/8] (0.55)
  0x00007fbfe024bc5d: add [r9d[4/8]] -> %eax[4/4] (4.9)

4.96
0x00007fbfe024bd6c: test [%eax[4/4]] -> %r10[4/8] (0.06)
  0x00007fbfe024bc5d: add [r9d[4/8]] -> %eax[4/4] (4.9)

4.68
0x00007fbfe024bc56: popcnt [rdi[8/8]] -> rsi[8/8] (0.42)
  0x00007fbfe024bc50: vpextrq [0x4[4/4], %xmm6[8/16]] -> rdi[8/8] (2.58)
    0x00007fbfe024bc4a: vextracti128 [0x4[4/4], %ymm10[16/32]] -> %xmm6[16/16] (0.38)
      0x00007fbfe024bb7a: vpand [0x30(%r13,%r10,8)[32/32], %ymm2[32/32]] -> %ymm10[32/32] (0.46)
        0x00007fbfe024bb73: vmovdqu [0x30(%rax,%r10,8)[32/32]] -> %ymm2[32/32] (0.84)

4.67
0x00007fbfe024bc45: popcnt [r9[8/8]] -> r9[8/8] (0.34)
  0x00007fbfe024bc3f: vpextrq [0x4[4/4], %xmm6[8/16]] -> r9[8/8] (2.82)
    0x00007fbfe024bc39: vextracti128 [0x4[4/4], %ymm10[16/32]] -> %xmm6[16/16] (0.21)
      0x00007fbfe024bb7a: vpand [0x30(%r13,%r10,8)[32/32], %ymm2[32/32]] -> %ymm10[32/32] (0.46)
        0x00007fbfe024bb73: vmovdqu [0x30(%rax,%r10,8)[32/32]] -> %ymm2[32/32] (0.84)

4.53
0x00007fbfe024bc9a: add [0x10[4/4]] -> %ecx[4/4] (4.53)

4.13
0x00007fbfe024bc8e: add [r14d[4/8]] -> %edx[4/4] (0.45)
  0x00007fbfe024bc8b: add [%ebx[4/4]] -> r14d[4/8] (3.68)

4.01
0x00007fbfe024bba5: popcnt [r10[8/8]] -> rax[8/8] (0.15)
  0x00007fbfe024bba0: vmovq [%xmm10[16/16]] -> r10[8/8] (3.86)

3.7800000000000002
0x00007fbfe024bbe6: popcnt [r11[8/8]] -> r11[8/8] (2.44)
  0x00007fbfe024bbe0: vpextrq [0x1[4/4], %xmm9[16/16]] -> r11[8/8] (1.34)

3.73
0x00007fbfe024bd0f: add [%edx[4/4]] -> %edi[4/4] (0.02)
  0x00007fbfe024bc97: add [r8d[4/8]] -> %edx[4/4] (3.71)

3.4400000000000004
0x00007fbfe024bc1e: popcnt [rdi[8/8]] -> rdi[8/8] (0.8)
  0x00007fbfe024bc18: vpextrq [0x1[4/4], %xmm8[16/16]] -> rdi[8/8] (2.64)

3.42
0x00007fbfe024bc25: add [%esi[4/4]] -> %ebp[4/4] (3.42)

3.2
0x00007fbfe024bc34: popcnt [r9[8/8]] -> rbx[8/8] (0.35)
  0x00007fbfe024bc2e: vpextrq [0x1[4/4], %xmm11[16/16]] -> r9[8/8] (2.85)

3.02
0x00007fbfe024bbb9: popcnt [r10[8/8]] -> rdx[8/8] (0.18)
  0x00007fbfe024bbb4: vmovq [%xmm9[16/16]] -> r10[8/8] (2.84)

2.61
0x00007fbfe024bb99: popcnt [r10[8/8]] -> rbp[8/8] (0.01)
  0x00007fbfe024bb94: vmovq [%xmm8[16/16]] -> r10[8/8] (2.6)

1.69
0x00007fbfe024bc91: add [r11d[4/8]] -> %edx[4/4] (1.69)

1.34
0x00007fbfe024bc94: add [r10d[1/8]] -> %edx[1/4] (1.34)
  0x00007fbfe024bb39: test [r10d[1/8]] -> r10d[1/8] (0.0)
    0x00007fbfe024bb31: movzbl [0x94(%r9)[1/4]] -> r10d[1/8] (0.0)

1.33
0x00007fbfe024bc77: add [r9d[4/8]] -> r14d[4/8] (1.33)

1.18
0x00007fbfe024bbf1: popcnt [r9[8/8]] -> r9[8/8] (0.97)
  0x00007fbfe024bbeb: vpextrq [0x1[4/4], %xmm10[16/16]] -> r9[8/8] (0.21)

1.08
0x00007fbfe024bc29: add [%ebp[4/4]] -> %eax[4/4] (0.7)
  0x00007fbfe024bc27: add [%ebx[4/4]] -> %ebp[4/4] (0.38)

0.87
0x00007fbfe024bc63: add [%ebx[4/4]] -> r14d[4/8] (0.87)

0.84
0x00007fbfe024bc2b: add [r9d[4/8]] -> %eax[4/4] (0.84)

0.84
0x00007fbfe024bbaf: popcnt [r10[8/8]] -> r14[8/8] (0.41)
  0x00007fbfe024bbaa: vmovq [%xmm11[16/16]] -> r10[8/8] (0.43)

0.56
0x00007fbfe024bc5b: add [%esi[4/4]] -> %eax[4/4] (0.56)

0.51
0x00007fbfe024bb9e: add [%edx[4/4]] -> %ebp[4/4] (0.51)

0.43000000000000005
0x00007fbfe024bdf8: popcnt [r9[8/8]] -> r9[8/8] (0.23)
  0x00007fbfe024bdf2: vpextrq [0x4[4/4], %xmm3[8/16]] -> r9[8/8] (0.05)
    0x00007fbfe024bdec: vextracti128 [0x4[4/4], %ymm2[16/32]] -> %xmm3[16/16] (0.11)
      0x00007fbfe024bde5: vpand [0x10(%r13,%rcx,8)[32/32], %ymm2[32/32]] -> %ymm2[32/32] (0.04)
        0x00007fbfe024bddf: vmovdqu [0x10(%rax,%rcx,8)[32/32]] -> %ymm2[32/32] (0.0)

0.41000000000000003
0x00007fbfe024bcef: popcnt [r10[8/8]] -> rsi[8/8] (0.27)
  0x00007fbfe024bce9: vpextrq [0x4[4/4], %xmm3[8/16]] -> r10[8/8] (0.01)
    0x00007fbfe024bce3: vextracti128 [0x4[4/4], %ymm2[16/32]] -> %xmm3[16/16] (0.06)
      0x00007fbfe024bcdc: vpand [0x10(%r13,%rcx,8)[32/32], %ymm2[32/32]] -> %ymm2[32/32] (0.06)
        0x00007fbfe024bcd6: vmovdqu [0x10(%rax,%rcx,8)[32/32]] -> %ymm2[32/32] (0.01)

0.37
0x00007fbfe024bd00: popcnt [r10[8/8]] -> r9[8/8] (0.11)
  0x00007fbfe024bcfa: vpextrq [0x4[4/4], %xmm3[8/16]] -> r10[8/8] (0.01)
    0x00007fbfe024bcf4: vextracti128 [0x4[4/4], %ymm2[16/32]] -> %xmm3[16/16] (0.18)
      0x00007fbfe024bcdc: vpand [0x10(%r13,%rcx,8)[32/32], %ymm2[32/32]] -> %ymm2[32/32] (0.06)
        0x00007fbfe024bcd6: vmovdqu [0x10(%rax,%rcx,8)[32/32]] -> %ymm2[32/32] (0.01)

0.35
0x00007fbfe024bc23: add [%edi[4/4]] -> %ebp[4/4] (0.35)

0.32
0x00007fbfe024bb62: movslq [%ecx[4/4]] -> r10[4/8] (0.32)

0.2
0x00007fbfe024bca1: jl [%ecx[0/4]] -> 0x00007fbfe024bca1 (0.0)
  0x00007fbfe024bc9d: cmp [0x50(%rsp)[4/4]] -> %ecx[4/4] (0.2)

0.18
0x00007fbfe024bd17: popcnt [r10[8/8]] -> r10[8/8] (0.06)
  0x00007fbfe024bd11: vpextrq [0x4[4/4], %xmm2[8/16]] -> r10[8/8] (0.08)
    0x00007fbfe024bb88: vmovq [rax[8/8]] -> %xmm2[8/16] (0.03)
      0x00007fbfe024bb50: vmovq [%xmm2[16/16]] -> rax[8/8] (0.01)

0.16
0x00007fbfe024be09: popcnt [rdi[8/8]] -> rdi[8/8] (0.0)
  0x00007fbfe024be03: vpextrq [0x4[4/4], %xmm3[8/16]] -> rdi[8/8] (0.0)
    0x00007fbfe024bdfd: vextracti128 [0x4[4/4], %ymm2[16/32]] -> %xmm3[16/16] (0.12)
      0x00007fbfe024bde5: vpand [0x10(%r13,%rcx,8)[32/32], %ymm2[32/32]] -> %ymm2[32/32] (0.04)
        0x00007fbfe024bddf: vmovdqu [0x10(%rax,%rcx,8)[32/32]] -> %ymm2[32/32] (0.0)

0.15000000000000002
0x00007fbfe024be29: add [%edi[4/4]] -> %edx[4/4] (0.01)
  0x00007fbfe024bd22: add [%esi[4/4]] -> %edi[4/4] (0.14)

0.15000000000000002
0x00007fbfe024be21: popcnt [r10[8/8]] -> r10[8/8] (0.1)
  0x00007fbfe024be1b: vpextrq [0x4[4/4], %xmm2[8/16]] -> r10[8/8] (0.01)
    0x00007fbfe024bb88: vmovq [rax[8/8]] -> %xmm2[8/16] (0.03)
      0x00007fbfe024bb50: vmovq [%xmm2[16/16]] -> rax[8/8] (0.01)

0.14
0x00007fbfe024bd2f: mov [%edi[4/4]] -> %edx[4/4] (0.0)
  0x00007fbfe024bd22: add [%esi[4/4]] -> %edi[4/4] (0.14)

0.14
0x00007fbfe024bd2b: mov [%edi[4/4]] -> %edx[4/4] (0.0)
  0x00007fbfe024bd22: add [%esi[4/4]] -> %edi[4/4] (0.14)

0.11
0x00007fbfe024be93: jmpq [%edx[0/4]] -> 0x00007fbfe024be93 (0.0)
  0x00007fbfe024be91: xor [%edx[4/4]] -> %edx[4/4] (0.0)
    0x00007fbfe024be2b: add [r9d[4/8]] -> %edx[4/4] (0.11)

0.11
0x00007fbfe024be35: mov [%edx[4/4]] -> r10d[4/8] (0.0)
  0x00007fbfe024be2b: add [r9d[4/8]] -> %edx[4/4] (0.11)

0.11
0x00007fbfe024bd24: add [0x4[4/4]] -> %ecx[4/4] (0.11)

0.1
0x00007fbfe024bd1f: add [r9d[4/8]] -> %edi[4/4] (0.1)

0.1
0x00007fbfe024bd0a: popcnt [r10[8/8]] -> rdi[8/8] (0.0)
  0x00007fbfe024bd05: vmovq [%xmm2[8/16]] -> r10[8/8] (0.06)
    0x00007fbfe024bb88: vmovq [rax[8/8]] -> %xmm2[8/16] (0.03)
      0x00007fbfe024bb50: vmovq [%xmm2[16/16]] -> rax[8/8] (0.01)

0.08
0x00007fbfe024be2e: add [0x4[4/4]] -> %ecx[4/4] (0.08)

0.08
0x00007fbfe024bd1c: add [r10d[1/8]] -> %edi[1/4] (0.08)
  0x00007fbfe024bb39: test [r10d[1/8]] -> r10d[1/8] (0.0)
    0x00007fbfe024bb31: movzbl [0x94(%r9)[1/4]] -> r10d[1/8] (0.0)

0.07
0x00007fbfe024be13: popcnt [rdx[8/8]] -> rdx[8/8] (0.0)
  0x00007fbfe024be0e: vmovq [%xmm2[8/16]] -> rdx[8/8] (0.03)
    0x00007fbfe024bb88: vmovq [rax[8/8]] -> %xmm2[8/16] (0.03)
      0x00007fbfe024bb50: vmovq [%xmm2[16/16]] -> rax[8/8] (0.01)

0.07
0x00007fbfe024bd42: mov [rdi[4/8]] -> 0x60(%rsp)[4/4] (0.0)
  0x00007fbfe024bd33: vmovq [%xmm0[16/16]] -> rdi[8/8] (0.07)

0.07
0x00007fbfe024bcc7: jge [%ecx[0/4]] -> 0x00007fbfe024bcc7 (0.0)
  0x00007fbfe024bcc4: cmp [r11d[4/8]] -> %ecx[4/4] (0.04)
    0x00007fbfe024bcb0: vmovd [%xmm4[16/16]] -> r11d[8/8] (0.03)

0.06999999999999999
0x00007fbfe024be82: vmovd [r8d[4/8]] -> %xmm7[4/16] (0.06)
  0x00007fbfe024be47: cmp [%ebx[4/4]] -> r8d[4/8] (0.0)
    0x00007fbfe024bdaa: cmp [%edx[4/4]] -> %ebx[4/4] (0.0)
      0x00007fbfe024bda5: mov [0x4[4/4]] -> %edx[4/4] (0.01)

0.06999999999999999
0x00007fbfe024be4d: cmovg [%ebx[4/4]] -> r10d[4/8] (0.06)
  0x00007fbfe024bdaa: cmp [%edx[4/4]] -> %ebx[4/4] (0.0)
    0x00007fbfe024bda5: mov [0x4[4/4]] -> %edx[4/4] (0.01)

0.05
0x00007fbfe024bdcf: jge [%ecx[0/4]] -> 0x00007fbfe024bdcf (0.0)
  0x00007fbfe024bdcc: cmp [r8d[4/8]] -> %ecx[4/4] (0.03)
    0x00007fbfe024bd94: mov [0xc(%r12,%rax,8)[4/4]] -> r8d[4/8] (0.02)

0.05
0x00007fbfe024bcc1: jge [%ecx[0/4]] -> 0x00007fbfe024bcc1 (0.0)
  0x00007fbfe024bcbf: cmp [%ebx[4/4]] -> %ecx[4/4] (0.02)
    0x00007fbfe024bcac: vmovd [%xmm5[16/16]] -> %ebx[4/4] (0.03)

0.04
0x00007fbfe024be6e: jge [%ecx[0/4]] -> 0x00007fbfe024be6e (0.0)
  0x00007fbfe024be6b: cmp [r9d[4/8]] -> %ecx[4/4] (0.04)
    0x00007fbfe024be67: cmovl [%edi[4/4]] -> r9d[4/8] (0.0)
      0x00007fbfe024be62: mov [0x80000000[4/4]] -> %edi[4/4] (0.0)

0.04
0x00007fbfe024bd91: mov [0x14(%rdi)[4/4]] -> %eax[4/4] (0.04)

0.04
0x00007fbfe024bd72: jne [r11d[0/8]] -> 0x00007fbfe024bd72 (0.0)
  0x00007fbfe024bd6f: test [r11d[1/8]] -> r11d[1/8] (0.0)
    0x00007fbfe024bd59: movzbl [0x94(%r9)[1/4]] -> r11d[1/8] (0.04)

0.04
0x00007fbfe024bd4f: callq [] -> 0x00007fbfe024bd4f (0.04)

0.04
0x00007fbfe024bd29: jl [%ecx[0/4]] -> 0x00007fbfe024bd29 (0.0)
  0x00007fbfe024bd27: cmp [%ebx[4/4]] -> %ecx[4/4] (0.01)
    0x00007fbfe024bcac: vmovd [%xmm5[16/16]] -> %ebx[4/4] (0.03)

0.04
0x00007fbfe024bcba: vmovq [%xmm2[8/16]] -> rax[8/8] (0.0)
  0x00007fbfe024bb88: vmovq [rax[8/8]] -> %xmm2[8/16] (0.03)
    0x00007fbfe024bb50: vmovq [%xmm2[16/16]] -> rax[8/8] (0.01)

0.03
0x00007fbfe024be5f: cmp [r9d[4/8]] -> r10d[4/8] (0.0)
  0x00007fbfe024be5b: add [0xfffffff4[4/4]] -> r9d[4/8] (0.03)

0.03
0x00007fbfe024bdac: mov [%ebx[4/4]] -> %esi[4/4] (0.02)
  0x00007fbfe024bdaa: cmp [%edx[4/4]] -> %ebx[4/4] (0.0)
    0x00007fbfe024bda5: mov [0x4[4/4]] -> %edx[4/4] (0.01)

0.02
0x00007fbfe024be4a: mov [r8d[4/8]] -> r10d[4/8] (0.01)
  0x00007fbfe024be47: cmp [%ebx[4/4]] -> r8d[4/8] (0.0)
    0x00007fbfe024bdaa: cmp [%edx[4/4]] -> %ebx[4/4] (0.0)
      0x00007fbfe024bda5: mov [0x4[4/4]] -> %edx[4/4] (0.01)

0.02
0x00007fbfe024be42: jmpq [r9[0/8]] -> 0x00007fbfe024be42 (0.0)
  0x00007fbfe024be3d: vmovq [%xmm1[4/16]] -> r9[4/8] (0.0)
    0x00007fbfe024bdd5: vmovq [r9[4/8]] -> %xmm1[4/16] (0.0)
      0x00007fbfe024bd54: mov [0x50(%rsp)[4/4]] -> r9[4/8] (0.02)

0.02
0x00007fbfe024be33: jge [%ecx[0/4]] -> 0x00007fbfe024be33 (0.0)
  0x00007fbfe024be31: cmp [%esi[4/4]] -> %ecx[4/4] (0.0)
    0x00007fbfe024bdb3: cmovg [%ecx[4/4]] -> %esi[4/4] (0.01)
      0x00007fbfe024bdae: mov [0x4[4/4]] -> %ecx[4/4] (0.01)

0.02
0x00007fbfe024bdba: lea [%r12,%r10,8[8/8]] -> r13[8/8] (0.02)

0.02
0x00007fbfe024bd82: jle [%ebx[0/4]] -> 0x00007fbfe024bd82 (0.0)
  0x00007fbfe024bd80: test [%ebx[4/4]] -> %ebx[4/4] (0.02)
    0x00007fbfe024bd7d: mov [0xc(%rdi)[4/4]] -> %ebx[4/4] (0.0)

0.02
0x00007fbfe024bd61: mov [0x108(%r15)[4/4]] -> r10[4/8] (0.02)

0.02
0x00007fbfe024bd47: mov [0x8(%rsp)[4/4]] -> rsi[4/8] (0.02)

0.02
0x00007fbfe024bd3d: mov [r9[4/8]] -> 0x50(%rsp)[4/4] (0.02)
  0x00007fbfe024bd38: vmovq [%xmm1[16/16]] -> r9[8/8] (0.0)

0.01
0x00007fbfe024be79: vmovd [%ebx[4/4]] -> %xmm5[4/16] (0.0)
  0x00007fbfe024bdaa: cmp [%edx[4/4]] -> %ebx[4/4] (0.0)
    0x00007fbfe024bda5: mov [0x4[4/4]] -> %edx[4/4] (0.01)

0.01
0x00007fbfe024be38: vmovq [%xmm0[4/16]] -> rdi[4/8] (0.0)
  0x00007fbfe024bdda: vmovq [rdi[4/8]] -> %xmm0[4/16] (0.0)
    0x00007fbfe024bd78: mov [0x60(%rsp)[4/4]] -> rdi[4/8] (0.01)

0.01
0x00007fbfe024be26: add [r10d[4/8]] -> %edx[4/4] (0.0)
  0x00007fbfe024bdc0: xor [r10d[4/8]] -> r10d[4/8] (0.01)
    0x00007fbfe024bd88: mov [0x10(%rdi)[4/4]] -> r10d[4/8] (0.0)

0.01
0x00007fbfe024be18: add [r10d[4/8]] -> %edx[4/4] (0.0)
  0x00007fbfe024bdc0: xor [r10d[4/8]] -> r10d[4/8] (0.01)
    0x00007fbfe024bd88: mov [0x10(%rdi)[4/4]] -> r10d[4/8] (0.0)

0.01
0x00007fbfe024bdbe: xor [%ecx[4/4]] -> %ecx[4/4] (0.0)
  0x00007fbfe024bdae: mov [0x4[4/4]] -> %ecx[4/4] (0.01)

0.01
0x00007fbfe024bd9f: jg [%ebx[0/4]] -> 0x00007fbfe024bd9f (0.0)
  0x00007fbfe024bd99: cmp [0x7ffffffc[4/4]] -> %ebx[4/4] (0.01)

0.01
0x00007fbfe024bd31: jmp [] -> 0x00007fbfe024bd31 (0.01)

0.0
0x00007fbfe024be98: mov [0x1[4/4]] -> %ebp[4/4] (0.0)

0.0
0x00007fbfe024be8c: jmpq [0x50(%rsp)[4/4]] -> 0x00007fbfe024be8c (0.0)

0.0
0x00007fbfe024be87: mov [r9d[4/8]] -> 0x50(%rsp)[4/4] (0.0)
  0x00007fbfe024be67: cmovl [%edi[4/4]] -> r9d[4/8] (0.0)
    0x00007fbfe024be62: mov [0x80000000[4/4]] -> %edi[4/4] (0.0)

0.0
0x00007fbfe024be7d: vmovd [r11d[4/8]] -> %xmm4[4/16] (0.0)
  0x00007fbfe024bd8c: mov [0xc(%r12,%r10,8)[4/4]] -> r11d[4/8] (0.0)

0.0
0x00007fbfe024be74: vmovq [rbp[4/8]] -> %xmm3[4/16] (0.0)
  0x00007fbfe024bd68: add [0x1[4/4]] -> rbp[4/8] (0.0)

0.0
0x00007fbfe024be58: mov [r10d[4/8]] -> r9d[4/8] (0.0)
  0x00007fbfe024be54: cmovg [r11d[4/8]] -> r10d[4/8] (0.0)
    0x00007fbfe024bd8c: mov [0xc(%r12,%r10,8)[4/4]] -> r11d[4/8] (0.0)

0.0
0x00007fbfe024be51: cmp [r11d[4/8]] -> r10d[4/8] (0.0)
  0x00007fbfe024bd8c: mov [0xc(%r12,%r10,8)[4/4]] -> r11d[4/8] (0.0)

0.0
0x00007fbfe024bdc6: jge [%ecx[0/4]] -> 0x00007fbfe024bdc6 (0.0)
  0x00007fbfe024bdc3: cmp [r11d[4/8]] -> %ecx[4/4] (0.0)
    0x00007fbfe024bd8c: mov [0xc(%r12,%r10,8)[4/4]] -> r11d[4/8] (0.0)

0.0
0x00007fbfe024bdb6: shl [0x3[4/4]] -> rax[4/8] (0.0)

0.0
0x00007fbfe024bd2d: jmp [] -> 0x00007fbfe024bd2d (0.0)

0.0
0x00007fbfe024bcd0: jge [%ecx[0/4]] -> 0x00007fbfe024bcd0 (0.0)
  0x00007fbfe024bccd: cmp [r8d[4/8]] -> %ecx[4/4] (0.0)
    0x00007fbfe024bcb5: vmovd [%xmm7[16/16]] -> r8d[8/8] (0.0)

0.0
0x00007fbfe024bca7: vmovq [%xmm3[16/16]] -> rbp[8/8] (0.0)

0.0
0x00007fbfe024bb4c: nopl [] -> 0x0(%rax)[2147483647/2147483647] (0.0)

0.0
0x00007fbfe024bb47: jmpq [%ebp[0/4]] -> 0x00007fbfe024bb47 (0.0)
  0x00007fbfe024bb42: mov [0x1[4/4]] -> %ebp[4/4] (0.0)

0.0
0x00007fbfe024bb3c: jne [r10d[0/8]] -> 0x00007fbfe024bb3c (0.0)
  0x00007fbfe024bb39: test [r10d[1/8]] -> r10d[1/8] (0.0)
    0x00007fbfe024bb31: movzbl [0x94(%r9)[1/4]] -> r10d[1/8] (0.0)
```

```
....[Hottest Region 1]..............................................................................
c2, level 4, com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtract

_jmhTest::vpandExtractPopcnt_thrpt_jmhStub, version 637 (818 bytes)

                                                                                 ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
                       0x00007fbfe024bb31: movzbl 0x94(%r9),%r10d                ;*arraylength {reexecute=0 rethrow=0 return_oop=0}
                                                                                 ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@17 (line 94)
                                                                                 ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
                                                                                 ; implicit exception: dispatches to 0x00007fbfe024c06a
                       0x00007fbfe024bb39: test   %r10d,%r10d
                       0x00007fbfe024bb3c: jne    0x00007fbfe024be98
                       0x00007fbfe024bb42: mov    $0x1,%ebp
         ╭             0x00007fbfe024bb47: jmpq   0x00007fbfe024bd78
         │             0x00007fbfe024bb4c: nopl   0x0(%rax)
  0.01%  │↗            0x00007fbfe024bb50: vmovq  %xmm2,%rax                     ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
         ││                                                                      ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
         ││                                                                      ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
         ││                                                                      ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.43%  ││        ↗   0x00007fbfe024bb55: vmovdqu 0x10(%rax,%rcx,8),%ymm2
  2.58%  ││        │   0x00007fbfe024bb5b: vpand  0x10(%r13,%rcx,8),%ymm2,%ymm8  ;*ifeq {reexecute=0 rethrow=0 return_oop=0}
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@33 (line 160)
  0.32%  ││        │   0x00007fbfe024bb62: movslq %ecx,%r10                      ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
         ││        │                                                             ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.43%  ││        │   0x00007fbfe024bb65: vmovdqu 0x70(%rax,%r10,8),%ymm2       ;*invokevirtual fromArray {reexecute=0 rethrow=0 return_oop=0}
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@38 (line 95)
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  2.65%  ││        │   0x00007fbfe024bb6c: vpand  0x70(%r13,%r10,8),%ymm2,%ymm9  ;*putfield arg$1 {reexecute=0 rethrow=0 return_oop=0}
         ││        │                                                             ; - jdk.incubator.vector.Long256Vector$Long256Species$$Lambda$46/0x00000008000dbc40::&lt;init&gt;@6
         ││        │                                                             ; - jdk.incubator.vector.Long256Vector$Long256Species$$Lambda$46/0x00000008000dbc40::get$Lambda@5
         ││        │                                                             ; - java.lang.invoke.DirectMethodHandle$Holder::invokeStatic@10
         ││        │                                                             ; - java.lang.invoke.Invokers$Holder::linkToTargetMethod@5
         ││        │                                                             ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@38 (line 1297)
         ││        │                                                             ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@3 (line 1150)
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@38 (line 95)
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.84%  ││        │   0x00007fbfe024bb73: vmovdqu 0x30(%rax,%r10,8),%ymm2
  0.46%  ││        │   0x00007fbfe024bb7a: vpand  0x30(%r13,%r10,8),%ymm2,%ymm10  ;*ifeq {reexecute=0 rethrow=0 return_oop=0}
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@33 (line 160)
  3.06%  ││        │   0x00007fbfe024bb81: vmovdqu 0x50(%rax,%r10,8),%ymm6       ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
         ││        │                                                             ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@81 (line 98)
         ││        │                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.03%  ││        │   0x00007fbfe024bb88: vmovq  %rax,%xmm2
  0.42%  ││        │   0x00007fbfe024bb8d: vpand  0x50(%r13,%r10,8),%ymm6,%ymm11
  2.60%  ││        │   0x00007fbfe024bb94: vmovq  %xmm8,%r10
  0.01%  ││        │   0x00007fbfe024bb99: popcnt %r10,%rbp
  0.51%  ││        │   0x00007fbfe024bb9e: add    %edx,%ebp
  3.86%  ││        │   0x00007fbfe024bba0: vmovq  %xmm10,%r10
  0.15%  ││        │   0x00007fbfe024bba5: popcnt %r10,%rax
  0.43%  ││        │   0x00007fbfe024bbaa: vmovq  %xmm11,%r10
  0.41%  ││        │   0x00007fbfe024bbaf: popcnt %r10,%r14
  2.84%  ││        │   0x00007fbfe024bbb4: vmovq  %xmm9,%r10
  0.18%  ││        │   0x00007fbfe024bbb9: popcnt %r10,%rdx
  0.35%  ││        │   0x00007fbfe024bbbe: vextracti128 $0x1,%ymm9,%xmm6
  0.41%  ││        │   0x00007fbfe024bbc4: vpextrq $0x0,%xmm6,%r10
  2.62%  ││        │   0x00007fbfe024bbca: popcnt %r10,%r10
  1.45%  ││        │   0x00007fbfe024bbcf: vextracti128 $0x1,%ymm9,%xmm6
  0.42%  ││        │   0x00007fbfe024bbd5: vpextrq $0x1,%xmm6,%r11
  2.20%  ││        │   0x00007fbfe024bbdb: popcnt %r11,%r8
  1.34%  ││        │   0x00007fbfe024bbe0: vpextrq $0x1,%xmm9,%r11
  2.44%  ││        │   0x00007fbfe024bbe6: popcnt %r11,%r11
  0.21%  ││        │   0x00007fbfe024bbeb: vpextrq $0x1,%xmm10,%r9
  0.97%  ││        │   0x00007fbfe024bbf1: popcnt %r9,%r9
  2.17%  ││        │   0x00007fbfe024bbf6: vextracti128 $0x1,%ymm8,%xmm6
  0.22%  ││        │   0x00007fbfe024bbfc: vpextrq $0x1,%xmm6,%rbx
  1.10%  ││        │   0x00007fbfe024bc02: popcnt %rbx,%rbx
  2.46%  ││        │   0x00007fbfe024bc07: vextracti128 $0x1,%ymm8,%xmm6
  0.22%  ││        │   0x00007fbfe024bc0d: vpextrq $0x0,%xmm6,%rdi
  1.00%  ││        │   0x00007fbfe024bc13: popcnt %rdi,%rsi
  2.64%  ││        │   0x00007fbfe024bc18: vpextrq $0x1,%xmm8,%rdi
  0.80%  ││        │   0x00007fbfe024bc1e: popcnt %rdi,%rdi
  0.35%  ││        │   0x00007fbfe024bc23: add    %edi,%ebp
  3.42%  ││        │   0x00007fbfe024bc25: add    %esi,%ebp
  0.38%  ││        │   0x00007fbfe024bc27: add    %ebx,%ebp
  0.70%  ││        │   0x00007fbfe024bc29: add    %ebp,%eax
  0.84%  ││        │   0x00007fbfe024bc2b: add    %r9d,%eax
  2.85%  ││        │   0x00007fbfe024bc2e: vpextrq $0x1,%xmm11,%r9
  0.35%  ││        │   0x00007fbfe024bc34: popcnt %r9,%rbx
  0.21%  ││        │   0x00007fbfe024bc39: vextracti128 $0x1,%ymm10,%xmm6
  2.82%  ││        │   0x00007fbfe024bc3f: vpextrq $0x1,%xmm6,%r9
  0.34%  ││        │   0x00007fbfe024bc45: popcnt %r9,%r9
  0.38%  ││        │   0x00007fbfe024bc4a: vextracti128 $0x1,%ymm10,%xmm6
  2.58%  ││        │   0x00007fbfe024bc50: vpextrq $0x0,%xmm6,%rdi
  0.42%  ││        │   0x00007fbfe024bc56: popcnt %rdi,%rsi
  0.56%  ││        │   0x00007fbfe024bc5b: add    %esi,%eax
  4.90%  ││        │   0x00007fbfe024bc5d: add    %r9d,%eax
  0.55%  ││        │   0x00007fbfe024bc60: add    %eax,%r14d
  0.87%  ││        │   0x00007fbfe024bc63: add    %ebx,%r14d
  1.46%  ││        │   0x00007fbfe024bc66: vextracti128 $0x1,%ymm11,%xmm6
  1.91%  ││        │   0x00007fbfe024bc6c: vpextrq $0x0,%xmm6,%r9
  0.12%  ││        │   0x00007fbfe024bc72: popcnt %r9,%r9
  1.33%  ││        │   0x00007fbfe024bc77: add    %r9d,%r14d
  2.20%  ││        │   0x00007fbfe024bc7a: vextracti128 $0x1,%ymm11,%xmm6
  0.08%  ││        │   0x00007fbfe024bc80: vpextrq $0x1,%xmm6,%r9
  2.51%  ││        │   0x00007fbfe024bc86: popcnt %r9,%rbx
  3.68%  ││        │   0x00007fbfe024bc8b: add    %ebx,%r14d
  0.45%  ││        │   0x00007fbfe024bc8e: add    %r14d,%edx
  1.69%  ││        │   0x00007fbfe024bc91: add    %r11d,%edx
  1.34%  ││        │   0x00007fbfe024bc94: add    %r10d,%edx
  3.71%  ││        │   0x00007fbfe024bc97: add    %r8d,%edx
  4.53%  ││        │   0x00007fbfe024bc9a: add    $0x10,%ecx
  0.20%  ││        │   0x00007fbfe024bc9d: cmp    0x50(%rsp),%ecx
         │╰        │   0x00007fbfe024bca1: jl     0x00007fbfe024bb50
         │         │   0x00007fbfe024bca7: vmovq  %xmm3,%rbp
  0.03%  │         │   0x00007fbfe024bcac: vmovd  %xmm5,%ebx
  0.03%  │         │   0x00007fbfe024bcb0: vmovd  %xmm4,%r11d
  0.00%  │         │   0x00007fbfe024bcb5: vmovd  %xmm7,%r8d
         │         │   0x00007fbfe024bcba: vmovq  %xmm2,%rax
  0.02%  │        ↗│   0x00007fbfe024bcbf: cmp    %ebx,%ecx
         │ ╭      ││   0x00007fbfe024bcc1: jge    0x00007fbfe024bd33             ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
         │ │      ││                                                             ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
         │ │      ││                                                             ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
         │ │      ││                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.07%  │ │      ││   0x00007fbfe024bcc3: nop                                   ;*invokestatic bitCount {reexecute=0 rethrow=0 return_oop=0}
         │ │      ││                                                             ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@62 (line 96)
         │ │      ││                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.04%  │ │  ↗   ││   0x00007fbfe024bcc4: cmp    %r11d,%ecx
         │ │  │   ││   0x00007fbfe024bcc7: jge    0x00007fbfe024bef2
         │ │  │   ││   0x00007fbfe024bccd: cmp    %r8d,%ecx
         │ │  │   ││   0x00007fbfe024bcd0: jge    0x00007fbfe024bf26
  0.01%  │ │  │   ││   0x00007fbfe024bcd6: vmovdqu 0x10(%rax,%rcx,8),%ymm2
  0.06%  │ │  │   ││   0x00007fbfe024bcdc: vpand  0x10(%r13,%rcx,8),%ymm2,%ymm2
  0.06%  │ │  │   ││   0x00007fbfe024bce3: vextracti128 $0x1,%ymm2,%xmm3
  0.01%  │ │  │   ││   0x00007fbfe024bce9: vpextrq $0x1,%xmm3,%r10
  0.27%  │ │  │   ││   0x00007fbfe024bcef: popcnt %r10,%rsi
  0.18%  │ │  │   ││   0x00007fbfe024bcf4: vextracti128 $0x1,%ymm2,%xmm3
  0.01%  │ │  │   ││   0x00007fbfe024bcfa: vpextrq $0x0,%xmm3,%r10
  0.11%  │ │  │   ││   0x00007fbfe024bd00: popcnt %r10,%r9
  0.06%  │ │  │   ││   0x00007fbfe024bd05: vmovq  %xmm2,%r10
         │ │  │   ││   0x00007fbfe024bd0a: popcnt %r10,%rdi
  0.02%  │ │  │   ││   0x00007fbfe024bd0f: add    %edx,%edi
  0.08%  │ │  │   ││   0x00007fbfe024bd11: vpextrq $0x1,%xmm2,%r10
  0.06%  │ │  │   ││   0x00007fbfe024bd17: popcnt %r10,%r10
  0.08%  │ │  │   ││   0x00007fbfe024bd1c: add    %r10d,%edi
  0.10%  │ │  │   ││   0x00007fbfe024bd1f: add    %r9d,%edi
  0.14%  │ │  │   ││   0x00007fbfe024bd22: add    %esi,%edi
  0.11%  │ │  │   ││   0x00007fbfe024bd24: add    $0x4,%ecx
  0.01%  │ │  │   ││   0x00007fbfe024bd27: cmp    %ebx,%ecx                      ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
         │ │  │   ││                                                             ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
         │ │  │   ││                                                             ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
         │ │  │   ││                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
         │ │╭ │   ││   0x00007fbfe024bd29: jl     0x00007fbfe024bd2f
  0.00%  │ ││ │   ││   0x00007fbfe024bd2b: mov    %edi,%edx
         │ ││╭│   ││   0x00007fbfe024bd2d: jmp    0x00007fbfe024bd33
         │ │↘││   ││   0x00007fbfe024bd2f: mov    %edi,%edx
  0.01%  │ │ │╰   ││   0x00007fbfe024bd31: jmp    0x00007fbfe024bcc4             ;*putfield arg$1 {reexecute=0 rethrow=0 return_oop=0}
         │ │ │    ││                                                             ; - jdk.incubator.vector.Long256Vector$Long256Species$$Lambda$46/0x00000008000dbc40::&lt;init&gt;@6
         │ │ │    ││                                                             ; - jdk.incubator.vector.Long256Vector$Long256Species$$Lambda$46/0x00000008000dbc40::get$Lambda@5
         │ │ │    ││                                                             ; - java.lang.invoke.DirectMethodHandle$Holder::invokeStatic@10
         │ │ │    ││                                                             ; - java.lang.invoke.Invokers$Holder::linkToTargetMethod@5
         │ │ │    ││                                                             ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@38 (line 1297)
         │ │ │    ││                                                             ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@3 (line 1150)
         │ │ │    ││                                                             ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@38 (line 95)
         │ │ │    ││                                                             ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.07%  │ ↘ ↘    ││   0x00007fbfe024bd33: vmovq  %xmm0,%rdi
         │        ││   0x00007fbfe024bd38: vmovq  %xmm1,%r9
  0.02%  │        ││↗  0x00007fbfe024bd3d: mov    %r9,0x50(%rsp)
         │        │││  0x00007fbfe024bd42: mov    %rdi,0x60(%rsp)
  0.02%  │        │││  0x00007fbfe024bd47: mov    0x8(%rsp),%rsi
         │        │││  0x00007fbfe024bd4c: vzeroupper
  0.04%  │        │││  0x00007fbfe024bd4f: callq  0x00007fbfd8765f00             ; ImmutableOopMap{[80]=Oop [88]=Oop [96]=Oop [8]=Oop }
         │        │││                                                            ;*invokevirtual consume {reexecute=0 rethrow=0 return_oop=0}
         │        │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@20 (line 158)
         │        │││                                                            ;   {optimized virtual_call}
  0.02%  │        │││  0x00007fbfe024bd54: mov    0x50(%rsp),%r9                 ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
         │        │││                                                            ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
         │        │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
         │        │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.04%  │        │││  0x00007fbfe024bd59: movzbl 0x94(%r9),%r11d                ;*invokestatic load {reexecute=0 rethrow=0 return_oop=0}
         │        │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@43 (line 1297)
         │        │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@3 (line 1150)
         │        │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@38 (line 95)
         │        │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.02%  │        │││  0x00007fbfe024bd61: mov    0x108(%r15),%r10               ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
         │        │││                                                            ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
         │        │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
         │        │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
         │        │││  0x00007fbfe024bd68: add    $0x1,%rbp                      ; ImmutableOopMap{r9=Oop [88]=Oop [96]=Oop [8]=Oop }
         │        │││                                                            ;*ifeq {reexecute=1 rethrow=0 return_oop=0}
         │        │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@33 (line 160)
  0.06%  │        │││  0x00007fbfe024bd6c: test   %eax,(%r10)                    ;   {poll}
         │        │││  0x00007fbfe024bd6f: test   %r11d,%r11d
         │        │││  0x00007fbfe024bd72: jne    0x00007fbfe024be9d
  0.01%  ↘        │││  0x00007fbfe024bd78: mov    0x60(%rsp),%rdi                ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
                  │││                                                            ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
                  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
                  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.00%           │││  0x00007fbfe024bd7d: mov    0xc(%rdi),%ebx                 ;*invokevirtual fromArray {reexecute=0 rethrow=0 return_oop=0}
                  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@38 (line 95)
                  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.02%           │││  0x00007fbfe024bd80: test   %ebx,%ebx
               ╭  │││  0x00007fbfe024bd82: jle    0x00007fbfe024be91             ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
               │  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
               │  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
               │  │││  0x00007fbfe024bd88: mov    0x10(%rdi),%r10d               ;*putfield arg$1 {reexecute=0 rethrow=0 return_oop=0}
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species$$Lambda$46/0x00000008000dbc40::&lt;init&gt;@6
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species$$Lambda$46/0x00000008000dbc40::get$Lambda@5
               │  │││                                                            ; - java.lang.invoke.DirectMethodHandle$Holder::invokeStatic@10
               │  │││                                                            ; - java.lang.invoke.Invokers$Holder::linkToTargetMethod@5
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@38 (line 1297)
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@3 (line 1150)
               │  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@38 (line 95)
               │  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
               │  │││  0x00007fbfe024bd8c: mov    0xc(%r12,%r10,8),%r11d         ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
               │  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
               │  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
               │  │││                                                            ; implicit exception: dispatches to 0x00007fbfe024c006
  0.04%        │  │││  0x00007fbfe024bd91: mov    0x14(%rdi),%eax                ;*putfield arg$1 {reexecute=0 rethrow=0 return_oop=0}
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species$$Lambda$46/0x00000008000dbc40::&lt;init&gt;@6
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species$$Lambda$46/0x00000008000dbc40::get$Lambda@5
               │  │││                                                            ; - java.lang.invoke.DirectMethodHandle$Holder::invokeStatic@10
               │  │││                                                            ; - java.lang.invoke.Invokers$Holder::linkToTargetMethod@5
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@38 (line 1297)
               │  │││                                                            ; - jdk.incubator.vector.Long256Vector$Long256Species::fromArray@3 (line 1150)
               │  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@38 (line 95)
               │  │││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.02%        │  │││  0x00007fbfe024bd94: mov    0xc(%r12,%rax,8),%r8d          ; implicit exception: dispatches to 0x00007fbfe024c006
  0.01%        │  │││  0x00007fbfe024bd99: cmp    $0x7ffffffc,%ebx
               │  │││  0x00007fbfe024bd9f: jg     0x00007fbfe024bed5
  0.01%        │  │││  0x00007fbfe024bda5: mov    $0x4,%edx
               │  │││  0x00007fbfe024bdaa: cmp    %edx,%ebx
  0.02%        │  │││  0x00007fbfe024bdac: mov    %ebx,%esi
  0.01%        │  │││  0x00007fbfe024bdae: mov    $0x4,%ecx
  0.01%        │  │││  0x00007fbfe024bdb3: cmovg  %ecx,%esi
               │  │││  0x00007fbfe024bdb6: shl    $0x3,%rax
  0.02%        │  │││  0x00007fbfe024bdba: lea    (%r12,%r10,8),%r13
  0.00%        │  │││  0x00007fbfe024bdbe: xor    %ecx,%ecx
  0.01%        │  │││  0x00007fbfe024bdc0: xor    %r10d,%r10d
               │ ↗│││  0x00007fbfe024bdc3: cmp    %r11d,%ecx
               │ ││││  0x00007fbfe024bdc6: jge    0x00007fbfe024beff
  0.03%        │ ││││  0x00007fbfe024bdcc: cmp    %r8d,%ecx
               │ ││││  0x00007fbfe024bdcf: jge    0x00007fbfe024bf33
  0.00%        │ ││││  0x00007fbfe024bdd5: vmovq  %r9,%xmm1
               │ ││││  0x00007fbfe024bdda: vmovq  %rdi,%xmm0                     ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
               │ ││││                                                            ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
               │ ││││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
               │ ││││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
               │ ││││  0x00007fbfe024bddf: vmovdqu 0x10(%rax,%rcx,8),%ymm2       ;*synchronization entry
               │ ││││                                                            ; - jdk.incubator.vector.Long256Vector::get@-1 (line 951)
               │ ││││                                                            ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@70 (line 97)
               │ ││││                                                            ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
  0.04%        │ ││││  0x00007fbfe024bde5: vpand  0x10(%r13,%rcx,8),%ymm2,%ymm2
  0.11%        │ ││││  0x00007fbfe024bdec: vextracti128 $0x1,%ymm2,%xmm3
  0.05%        │ ││││  0x00007fbfe024bdf2: vpextrq $0x1,%xmm3,%r9
  0.23%        │ ││││  0x00007fbfe024bdf8: popcnt %r9,%r9
  0.12%        │ ││││  0x00007fbfe024bdfd: vextracti128 $0x1,%ymm2,%xmm3
               │ ││││  0x00007fbfe024be03: vpextrq $0x0,%xmm3,%rdi
               │ ││││  0x00007fbfe024be09: popcnt %rdi,%rdi
  0.03%        │ ││││  0x00007fbfe024be0e: vmovq  %xmm2,%rdx
               │ ││││  0x00007fbfe024be13: popcnt %rdx,%rdx
               │ ││││  0x00007fbfe024be18: add    %r10d,%edx
  0.01%        │ ││││  0x00007fbfe024be1b: vpextrq $0x1,%xmm2,%r10
  0.10%        │ ││││  0x00007fbfe024be21: popcnt %r10,%r10
  0.00%        │ ││││  0x00007fbfe024be26: add    %r10d,%edx
  0.01%        │ ││││  0x00007fbfe024be29: add    %edi,%edx
  0.11%        │ ││││  0x00007fbfe024be2b: add    %r9d,%edx
  0.08%        │ ││││  0x00007fbfe024be2e: add    $0x4,%ecx
               │ ││││  0x00007fbfe024be31: cmp    %esi,%ecx
               │╭││││  0x00007fbfe024be33: jge    0x00007fbfe024be47
               ││││││  0x00007fbfe024be35: mov    %edx,%r10d
               ││││││  0x00007fbfe024be38: vmovq  %xmm0,%rdi
               ││││││  0x00007fbfe024be3d: vmovq  %xmm1,%r9
               ││╰│││  0x00007fbfe024be42: jmpq   0x00007fbfe024bdc3
               │↘ │││  0x00007fbfe024be47: cmp    %ebx,%r8d
  0.01%        │  │││  0x00007fbfe024be4a: mov    %r8d,%r10d
  0.06%        │  │││  0x00007fbfe024be4d: cmovg  %ebx,%r10d
               │  │││  0x00007fbfe024be51: cmp    %r11d,%r10d
               │  │││  0x00007fbfe024be54: cmovg  %r11d,%r10d
               │  │││  0x00007fbfe024be58: mov    %r10d,%r9d
  0.03%        │  │││  0x00007fbfe024be5b: add    $0xfffffff4,%r9d
               │  │││  0x00007fbfe024be5f: cmp    %r9d,%r10d
  0.00%        │  │││  0x00007fbfe024be62: mov    $0x80000000,%edi
               │  │││  0x00007fbfe024be67: cmovl  %edi,%r9d
  0.04%        │  │││  0x00007fbfe024be6b: cmp    %r9d,%ecx
               │  ╰││  0x00007fbfe024be6e: jge    0x00007fbfe024bcbf
               │   ││  0x00007fbfe024be74: vmovq  %rbp,%xmm3
               │   ││  0x00007fbfe024be79: vmovd  %ebx,%xmm5
  0.00%        │   ││  0x00007fbfe024be7d: vmovd  %r11d,%xmm4
  0.06%        │   ││  0x00007fbfe024be82: vmovd  %r8d,%xmm7
               │   ││  0x00007fbfe024be87: mov    %r9d,0x50(%rsp)
               │   ╰│  0x00007fbfe024be8c: jmpq   0x00007fbfe024bb55
               ↘    │  0x00007fbfe024be91: xor    %edx,%edx
                    ╰  0x00007fbfe024be93: jmpq   0x00007fbfe024bd3d             ;*invokestatic extract {reexecute=0 rethrow=0 return_oop=0}
                                                                                 ; - jdk.incubator.vector.Long256Vector::get@43 (line 954)
                                                                                 ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@92 (line 99)
                                                                                 ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
                       0x00007fbfe024be98: mov    $0x1,%ebp                      ;*arraylength {reexecute=0 rethrow=0 return_oop=0}
                                                                                 ; - com.openkappa.panama.vectorbenchmarks.IntersectionCardinality::vpandExtractPopcnt@17 (line 94)
                                                                                 ; - com.openkappa.panama.vectorbenchmarks.generated.IntersectionCardinality_vpandExtractPopcnt_jmhTest::vpandExtractPopcnt_thrpt_jmhStub@17 (line 158)
....................................................................................................
```
