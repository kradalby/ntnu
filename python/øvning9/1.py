
def utube_cropper(li):
    for i in range(len(li)):
        m = li[i]
        m = m[31:]
        li[i] = "youtu.be/" + m
        
    return li
    
    

vid = [
'http://www.youtube.com/watch?v=oKI-tD0L18A',
'http://www.youtube.com/watch?v=82LCKBdjywQ',
'http://www.youtube.com/watch?v=GpNSip5gyKo',
'http://www.youtube.com/watch?v=rHG-JO8gIGk',
'http://www.youtube.com/watch?v=ZFngtBIxRPk',
'http://www.youtube.com/watch?v=OZBWfyYtYQY'
]


vid_crop = utube_cropper(vid)

print(vid_crop)
