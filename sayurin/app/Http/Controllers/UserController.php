<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\User;
use Illuminate\Support\Facades\Input;

class UserController extends Controller
{    
    public function __construct()
    {
        $this->middleware(['auth', 'admin']);
    }

    public function manageUser()
    {
        $user = User::where('tipe', 'user')->get();
        return view('manage-user', [
            'user' => $user
        ]);
    }
    
    public function chatUser()
    {
        return view('chat');
    }

    public function search()
    {
        $keyword = Input::get('search');
        $search = User::where('tipe', 'user')->where('name',"LIKE","%$keyword%")->paginate(20);

        return view('manage-user', [            
            'user' => $search
        ]);
    }

    public function delete($id)
    {
        $users = User::findOrFail($id);
        $users->delete();
        return redirect()->back();
    }
}
