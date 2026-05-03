class RotateString_796:
     def rotateString(self, s: str, goal: str) -> bool:
          if(len(s) != len(goal)):
            return False
          concatenatedStr = s + s
          targetLen = len(goal)
          for i in range(0, len(concatenatedStr) -targetLen + 1):
               if(concatenatedStr[i:i+targetLen] == goal):
                    return True
          
          return False
     
     def rotateString_better(self, s: str, goal: str) -> bool:
         if(len(s) != len(goal)):
            return False
         return goal in (s + s)
         
        

