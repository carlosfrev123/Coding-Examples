from django.urls import path
from . import views

app_name="foodapp"
urlpatterns = [
    path("", views.index, name="index"),
    path('login/', views.login, name='login'),
    path('logout/', views.user_logout, name='logout')
]