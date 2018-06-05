<?php

namespace App\Console\Commands;

use App\User;
use Illuminate\Console\Command;

class CreateUser extends Command
{
    /**
     * The name and signature of the console command.
     *
     * @var string
     */
    protected $signature = 'user:create {name} {email} {nomor_telepon} {password} {tipe}';

    /**
     * The console command description.
     *
     * @var string
     */
    protected $description = 'Create a new user';

    /**
     * Create a new command instance.
     *
     * @return void
     */
    public function __construct()
    {
        parent::__construct();
    }

    /**
     * Execute the console command.
     *
     * @return mixed
     */
    public function handle()
    {
        User::create([
            'name'          => $this->argument('name'),
            'email'         => $this->argument('email'),
            'nomor_telepon' => $this->argument('nomor_telepon'),
            'password'      => bcrypt($this->argument('password')),
            'tipe'          => $this->argument('tipe'),
        ]);
    }
}
