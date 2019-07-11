# 牛逼的抠图功能
from removebg import RemoveBg
import os

rmbg = RemoveBg("8snqYXbpSn8EJRntH16A9ZTA", "error.log")
# rmbg.remove_background_from_img_file("C:/Users/zhangchg/OneDrive/zcg/文档/个人信息/liuyanning1.jpg") #图片地址
#图片放到程序的同级文件夹 picture 里面
path = '%s/picture'%os.getcwd()
for pic in os.listdir(path):
    rmbg.remove_background_from_img_file("%s\%s"%(path,pic))