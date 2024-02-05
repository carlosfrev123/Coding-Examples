from django.shortcuts import render
from django.http import HttpResponse, HttpResponseRedirect
from django.contrib.auth import logout

# Create your views here.
def index(request):
    if not request.user.is_authenticated:
        return HttpResponseRedirect('/login')

    return render(request, "foodapp/index.html")

def login(request):
    if request.user.is_authenticated:
        return HttpResponseRedirect('/')

    return render(request, "login.html")

def user_logout(request):
    logout(request)
    return HttpResponseRedirect('/login')